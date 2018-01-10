package com;

import org.junit.Test;

public class CarExtendProxyTest {

    @Test
    public void testMove() {
        Moveable moveable = new CarExtendProxy();
        moveable.move();
    }
}
