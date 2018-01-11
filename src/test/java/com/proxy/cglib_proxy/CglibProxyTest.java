package com.proxy.cglib_proxy;

import com.proxy.Train;
import org.junit.Test;

public class CglibProxyTest {

    @Test
    public void test() {
        CglibProxy proxy = new CglibProxy();
        Train t = (Train) proxy.getProxy(Train.class);
        t.move();
    }
}
