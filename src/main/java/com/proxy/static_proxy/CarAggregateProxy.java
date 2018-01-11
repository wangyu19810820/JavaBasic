package com.proxy.static_proxy;

import com.proxy.Moveable;

public class CarAggregateProxy implements Moveable {

    private Moveable car1;

    public CarAggregateProxy(Moveable car1) {
        this.car1 = car1;
    }

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车(CarAggregateProxy)开始行驶。。。");

        car1.move();

        long endtime = System.currentTimeMillis();
        System.out.println("汽车(CarAggregateProxy)行驶结束。。。所用时间：" + (endtime - starttime) + "毫秒");
    }
}
