package com;

import org.junit.Test;

public class CarAggregateProxyTest {

    @Test
    public void testMove() {
        Moveable car = new CarAggregateProxy(new Car1());
        car.move();
    }
}
