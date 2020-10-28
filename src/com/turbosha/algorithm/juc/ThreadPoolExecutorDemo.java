package com.turbosha.algorithm.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 10, 500, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
//                new BasicThreadFactory.Builder().namingPattern("turbosha-%d").daemon(true).build(),
                new ThreadPoolExecutor.DiscardPolicy());
        Runtime.getRuntime().exit(1);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new MyThread());
            String info = String.format("线程池中线程数目：%s，队列中等待执行的任务数目：%s，已执行玩别的任务数目：%s，线程池最大数组：%s",
                    threadPoolExecutor.getPoolSize(),
                    threadPoolExecutor.getQueue().size(),
                    threadPoolExecutor.getCompletedTaskCount(),
                    threadPoolExecutor.getLargestPoolSize());
            System.out.println(info);
        }
        threadPoolExecutor.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!threadPoolExecutor.isTerminated()){ }
        String info = String.format("线程池中线程数目：%s，队列中等待执行的任务数目：%s，已执行玩别的任务数目：%s，线程池最大数组：%s",
                threadPoolExecutor.getPoolSize(),
                threadPoolExecutor.getQueue().size(),
                threadPoolExecutor.getCompletedTaskCount(),
                threadPoolExecutor.getLargestPoolSize());
        System.out.println(info);
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 执行");
        }

    }
}
