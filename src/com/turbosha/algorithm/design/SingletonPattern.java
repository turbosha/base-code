package com.turbosha.algorithm.design;

/**
 * @Description 单例模式
 * @Author luoyuansha
 * @Date 2020/10/28 12:42
 */
public class SingletonPattern {

    /**
     * 1.饿汉式：线程安全，耗费资源
     */
    static class HugerSingleton1 {
        //该对象的引用不可修改
        private static final HugerSingleton1 ourInstance = new HugerSingleton1();

        public static HugerSingleton1 getInstance() {
            return ourInstance;
        }

        private HugerSingleton1() {
        }
    }

    /**
     * 2.饿汉式：在静态代码块实例对象
     */
    static class HugerSingleton2 {
        private static HugerSingleton2 ourInstance;

        static {
            ourInstance = new HugerSingleton2();
        }

        public static HugerSingleton2 getInstance() {
            return ourInstance;
        }

        private HugerSingleton2() {
        }
    }

    /**
     * 3.懒汉式：非线程安全
     */
    static class Singleton1 {
        private static Singleton1 ourInstance;

        public static Singleton1 getInstance() {
            if (null == ourInstance) {
                ourInstance = new Singleton1();
            }
            return ourInstance;
        }

        private Singleton1() {
        }
    }

    /**
     * 4.线程安全的懒汉式：给方法加锁
     */
    static class Singleton2 {
        private static Singleton2 ourInstance;

        public synchronized static Singleton2 getInstance() {
            if (null == ourInstance) {
                ourInstance = new Singleton2();
            }
            return ourInstance;
        }

        private Singleton2() {
        }
    }

    /**
     * 5.线程安全的懒汉式：双重检查锁（同步代码块）
     */
    static class Singleton3 {
        private static volatile Singleton3 ourInstance;

        public static Singleton3 getInstance() {
            if (null == ourInstance) {
                synchronized (Singleton3.class) {
                    if (null == ourInstance) {
                        // 双重检测锁，加volatile关键则，防止重排序
                        /**
                         * 创建对象过程
                         * 1、jvm分配内存空间
                         * 2、初始化instance对象
                         * 3、instance指向内存的地址
                         */
                        ourInstance = new Singleton3();
                    }
                }
            }
            return ourInstance;
        }

        private Singleton3() {
        }
    }

    /**
     * 6.线程安全的懒汉式：静态内部类（推荐）
     */
    static class Singleton4 {
        private static class SingletonHolder {
            private static Singleton4 ourInstance = new Singleton4();
        }

        public static Singleton4 getInstance() {
            return SingletonHolder.ourInstance;
        }

        private Singleton4() {
        }
    }

    /**
     * 7.线程安全的懒汉式：枚举
     */
    enum Singleton5 {
        INSTANCE;

        public void whateverMethod() {
            // do something
        }
    }
}
