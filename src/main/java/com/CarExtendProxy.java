package com;

public class CarExtendProxy extends Car1 {

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车(CarExtendProxy)开始行驶。。。");

        super.move();

        long endtime = System.currentTimeMillis();
        System.out.println("汽车(CarExtendProxy)行驶结束。。。所用时间：" + (endtime - starttime) + "毫秒");
    }
}
