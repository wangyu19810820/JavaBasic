package com.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理实现方法
 */
public class TimeInvocationHandler implements InvocationHandler {

    private Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 被代理的对象
     * @param method 被代理对象的方法
     * @param args 方法的参数
     * @return 方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车(TimeInvocationHandler)开始行驶。。。");

        method.invoke(target);

        long endtime = System.currentTimeMillis();
        System.out.println("汽车(TimeInvocationHandler)行驶结束。。。所用时间：" + (endtime - starttime) + "毫秒");
        return null;
    }
}
