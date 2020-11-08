package com.turbosha.algorithm.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void main(String[] args) {
        // https://blog.csdn.net/tjbsl/article/details/98480843
        ExecutorService executorService0 = Executors.newCachedThreadPool();// 0  Integer.MAX_VALUE
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);// n  n
        ExecutorService executorService2 = Executors.newSingleThreadExecutor(); // 1  1
        ExecutorService executorService3 = Executors.newScheduledThreadPool(10); // n  Integer.MAX_VALUE
        ExecutorService executorService4 = Executors.newWorkStealingPool();// JDK8新增，默认Runtime.getRuntime().availableProcessors()

        /**
         * ThreadPoolExecutor线程池
         * 状态：
         * RUNNING：接受新任务和处理阻塞队列任务
         * SHUTDOWN：不再接受新任务，但处理阻塞队列任务
         * STOP：不再接受新任务，也不处理阻塞队列里的任务，并且打断正在处理的任务
         * TIDYING：所有任务都种植，workCount=0，即将调用terminated()方法
         * TERMINATED：terminated() 方法调用完成
         */
    }
}
