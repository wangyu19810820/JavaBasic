package com.proxy.jdk_proxy;

import com.proxy.Car;
import com.proxy.Car1;
import com.proxy.Moveable;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class TimeInvocationHandlerTest {

    @Test
    public void test() {
        Car1 car = new Car1();
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(car);
        Class<?> cls = car.getClass();
        // newProxyInstance的三个参数：类加载器，实现接口，代理方法处理类
        // 返回动态代理类
        Moveable m = (Moveable)Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), timeInvocationHandler);
        m.move();
    }
}
