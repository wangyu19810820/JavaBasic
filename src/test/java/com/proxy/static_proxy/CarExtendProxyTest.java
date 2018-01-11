package com.proxy.static_proxy;

import com.proxy.Moveable;
import com.proxy.static_proxy.CarExtendProxy;
import org.junit.Test;

public class CarExtendProxyTest {

    @Test
    public void testMove() {
        Moveable moveable = new CarExtendProxy();
        moveable.move();
    }
}
