package com.proxy.simulate;
import com.proxy.Moveable;
public class $Proxy implements Moveable {
private Moveable moveable;
public $Proxy(Moveable moveable) {this.moveable = moveable;}
public void move() {
long starttime = System.currentTimeMillis();
System.out.println("汽车($Proxy)开始行驶。。。");
moveable.move();
long endtime = System.currentTimeMillis();
System.out.println("汽车(CarAggregateProxy)行驶结束。。。所用时间：" + (endtime - starttime) + "毫秒");
}
}