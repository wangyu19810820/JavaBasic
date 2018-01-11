package com.proxy.static_proxy;

import com.proxy.Car1;
import com.proxy.Moveable;
import com.proxy.static_proxy.CarAggregateProxy;
import com.proxy.static_proxy.CarLogProxy;
import org.junit.Test;

public class CarAggregateProxyTest {

    @Test
    public void testMove() {
        Moveable car = new CarAggregateProxy(new Car1());
        car.move();
    }

    @Test
    public void test1() {
        Moveable car = new Car1();
        Moveable aggregateProxy = new CarAggregateProxy(car);
        Moveable logCar = new CarLogProxy(aggregateProxy);
        logCar.move();
    }
}
