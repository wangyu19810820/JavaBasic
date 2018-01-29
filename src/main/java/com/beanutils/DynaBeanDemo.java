package com.beanutils;

import org.apache.commons.beanutils.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * DynaBean的demo
 * DynaProperty、DynaClass、DynaBean动态构造一个bean，这个bean只能用DynaBean方法或其他javabean内省机制访问属性
 * LazyDynaBean是一个类似JavaScript的对象，访问属性采用DynaBean的接口
 */
public class DynaBeanDemo {

    public static void main(String[] args) throws Exception {
        DynaProperty[] props = new DynaProperty[]{
                new DynaProperty("address", Map.class),
                new DynaProperty("subordinate", Employee[].class),
                new DynaProperty("firstName", String.class),
                new DynaProperty("lastName", String.class)
        };
        DynaClass dynaClass = new BasicDynaClass("employee", null, props);
        DynaBean dynaBean = dynaClass.newInstance();
        dynaBean.set("firstName", "abc");
        System.out.println(PropertyUtils.getProperty(dynaBean,"firstName"));

        LazyDynaBean lazyDynaBean = new LazyDynaBean();
        lazyDynaBean.set("firstName", "aaa");
        lazyDynaBean.set("lastName", "bbb");
        lazyDynaBean.set("subordinate", 1, new Employee("xxx", "yyy"));
        System.out.println(PropertyUtils.getProperty(lazyDynaBean, "firstName"));
        System.out.println(PropertyUtils.getProperty(lazyDynaBean, "lastName"));
        System.out.println(PropertyUtils.getProperty(lazyDynaBean, "subordinate[1]"));
        Map map = lazyDynaBean.getMap();
        for (Object key : map.keySet()) {
            System.out.println("" + key + ":" + map.get(key));
        }

        LazyDynaList lazyDynaList = new LazyDynaList();
        lazyDynaList.setElementType(Address.class);
        lazyDynaList.add(1, new Address("a"));
        System.out.println(Arrays.toString(lazyDynaList.toArray()));
    }
}
