package com.beanutils;

import org.apache.commons.beanutils.BeanPropertyValueChangeClosure;
import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * CollectionUtils的demo
 * 更改集合中bean属性的值，根据条件过滤集合，由一个集合转换成另一个集合
 */
public class CollectionUtilsDemo {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        User u1 = new User();
        u1.setId("11");
        u1.setName("chenpi1");
        u1.setState(true);

        User u2 = new User();
        u2.setId("21");
        u2.setName("chenpi2");

        User u3 = new User();
        u3.setId("31");
        u3.setName("chenpi3");
        u3.setState(true);

        userList.add(u1);
        userList.add(u2);
        userList.add(u3);

        // 更改集合中bean属性的值
        BeanPropertyValueChangeClosure closure = new BeanPropertyValueChangeClosure(
                "name", "updateName");
        CollectionUtils.forAllDo(userList, closure);
        userList.forEach(System.out::println);
        System.out.println("------------------------------------------------------");

        // 根据条件过滤集合
        BeanPropertyValueEqualsPredicate predicate = new BeanPropertyValueEqualsPredicate(
                "state", Boolean.TRUE);
        CollectionUtils.filter(userList, predicate);
        userList.forEach(System.out::println);
        System.out.println("------------------------------------------------------");

        // 由一个集合转换成另一个集合
        BeanToPropertyValueTransformer transformer = new BeanToPropertyValueTransformer("id");
        Collection<?> idList = CollectionUtils.collect(userList, transformer);
        idList.forEach(System.out::println);
    }
}
