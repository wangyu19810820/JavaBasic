package com;

import java.util.Random;

public class Car implements Moveable {

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶。。。");

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endtime = System.currentTimeMillis();
        System.out.println("汽车行驶结束。。。所用时间：" + (endtime - starttime) + "毫秒");
    }
}
