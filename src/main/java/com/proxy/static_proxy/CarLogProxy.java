package com.proxy.static_proxy;

import com.proxy.Moveable;

public class CarLogProxy implements Moveable {

    private Moveable moveable;

    public CarLogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("CarLogProxy begin");
        this.moveable.move();
        System.out.println("CarLogProxy end");
    }
}
