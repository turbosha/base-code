package com.turbosha.algorithm.juc;

import java.util.Objects;
import java.util.concurrent.*;

public class ThreadPoolDemo {
    // 成员变量
    private volatile ExecutorService executor;

    //单例模式创建
    private ExecutorService getExecutorService(){
        if(executor == null){
            synchronized (this){
                if(executor == null){
                    // 获取程序运行环境 Runtime，获取虚拟机的处理数
                    int availableProcessors = Runtime.getRuntime().availableProcessors();
                    int maximumPoolSize = availableProcessors * 4;
                    int queueCapacity = availableProcessors * 100;
                    long keepAliveTime = 60L;
                    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(queueCapacity);
                    executor = new ThreadPoolExecutor(
                            availableProcessors,
                            maximumPoolSize,
                            keepAliveTime,
                            TimeUnit.SECONDS,
                            workQueue,
                            new ThreadPoolExecutor.DiscardPolicy());

                    // 关闭客户端(关闭后台线程)
                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        if(Objects.nonNull(executor)){
                            executor.shutdown();
                        }
                    }));
                }
            }
        }
        return executor;
    }
}
