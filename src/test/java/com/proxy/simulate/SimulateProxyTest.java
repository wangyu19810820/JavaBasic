package com.proxy.simulate;

import com.proxy.Moveable;
import org.junit.Test;

public class SimulateProxyTest {

    @Test
    public void newProxyInstanceTest() {
        try {
            Moveable m = (Moveable)SimulateProxy.newProxyInstance(Moveable.class);
            m.move();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
