package com.turbosha.algorithm.test;

import java.lang.reflect.Proxy;

public class ProxyTest {

//    private static Object getProxy(final Object target) throws Exception {
//        Class<?> proxyClass = Proxy.getProxyClass(
//                target.getClass().getClassLoader(), // 参数1：类加载器
//                target.getClass().getInterfaces()); // 参数2: 目标对象实现的接口，让代理对象实现相同接口
//        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
//        Object proxy = constructor.newInstance((InvocationHandler) (proxy1, method, args) -> {
//            System.out.println(method.getName() + "方法开始执行......");
//            Object result = method.invoke(target, args);
//            System.out.println(result);
//            System.out.println(method.getName() + "方法执行结束......");
//            return result;
//        });
//        return proxy;
//    }

    private static Object getProxy(final Object target) throws Exception {
        Object proxyInstance = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println(method.getName() + "方法开始执行......");
                    Object result = method.invoke(target, args);
                    System.out.println(result);
                    System.out.println(method.getName() + "方法执行结束......");
                    return result;
                }
        );
        return proxyInstance;
    }
}
