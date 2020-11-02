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
    }
}
