package com.proxy;

import java.util.Random;

public class Car1 implements Moveable {

    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("car moving");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
