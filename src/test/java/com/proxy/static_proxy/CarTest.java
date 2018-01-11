package com.proxy.static_proxy;

import com.proxy.Car;
import org.junit.Test;

public class CarTest {

    @Test
    public void test() {
        Car car = new Car();
        car.move();
    }
}
