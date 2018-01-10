package com;

import java.util.Random;

public class Car1 implements Moveable {

    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
