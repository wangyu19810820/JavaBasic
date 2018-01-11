package com.proxy.jdk_proxy;

import com.proxy.Car1;
import com.proxy.Moveable;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class CarInvocationHandlerTest {

    @Test
    public void test() {
        Car1 car = new Car1();
        Class<?> cls = car.getClass();

        TimeInvocationHandler th = new TimeInvocationHandler(car);
        Moveable m1 = (Moveable)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), th);
        LogInvocationHandler lh = new LogInvocationHandler(m1);
        Moveable m2 = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), lh);
        m2.move();

    }
}
