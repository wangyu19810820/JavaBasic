package com.proxy.simulate;

import com.proxy.Car1;
import com.proxy.Moveable;
import com.proxy.jdk_proxy.TimeInvocationHandler;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;

public class SimulateProxy1Test {

    @Test
    public void newProxyInstanceTest() {
        try {
            InvocationHandler invocationHandler = new TimeInvocationHandler(new Car1());
            Moveable m = (Moveable)SimulateProxy1.newProxyInstance(Moveable.class, invocationHandler);
            m.move();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
