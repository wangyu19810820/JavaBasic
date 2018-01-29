package com.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

/**
 *  PropertyUtils可以动态访问bean的属性
 */
public class PropertyUtilsDemo {

    public static void main(String[] args) throws Exception {
        Employee employee = new Employee();

        // 设置、获取基本类型的属性
        PropertyUtils.setSimpleProperty(employee, "firstName", "abc");
        System.out.println(PropertyUtils.getSimpleProperty(employee, "firstName"));

        // 设置、获取索引类型的属性，有两种写法
        PropertyUtils.setIndexedProperty(employee, "subordinate", 0, new Employee("tom", "green"));
        System.out.println(PropertyUtils.getIndexedProperty(employee, "subordinate",0));
        PropertyUtils.setIndexedProperty(employee, "subordinate[1]", new Employee("jerry", "blue"));
        System.out.println(PropertyUtils.getIndexedProperty(employee, "subordinate[1]"));

        // 设置、获取Map类型的属性，有两种写法
        PropertyUtils.setMappedProperty(employee, "employeeMap(a)", new Employee("a", "b"));
        PropertyUtils.setMappedProperty(employee, "employeeMap", "z", new Employee("z", "y"));
        System.out.println(PropertyUtils.getMappedProperty(employee, "employeeMap", "a"));
        System.out.println(PropertyUtils.getMappedProperty(employee, "employeeMap(z)"));

        // 设置、获取嵌套类型的属性
        employee.setAddress("home", new Address());
        PropertyUtils.setNestedProperty(employee, "address(home).city", "nanjing");
        System.out.println(PropertyUtils.getNestedProperty(employee, "address(home).city"));

        // 设置、获取属性通用写法
        // 基本类型
        PropertyUtils.setProperty(employee, "firstName", "efg");
        System.out.println(PropertyUtils.getProperty(employee, "firstName"));
        // 索引类型
        PropertyUtils.setProperty(employee, "subordinate[2]", new Employee("y", "z"));
        System.out.println(PropertyUtils.getProperty(employee, "subordinate[2]"));
        // map类型
        PropertyUtils.setProperty(employee, "employeeMap(x)", new Employee("x", "y"));
        System.out.println(PropertyUtils.getProperty(employee, "employeeMap(x)"));
        // 嵌套类型
        PropertyUtils.setProperty(employee, "address(home).city", "shanghai");
        System.out.println(PropertyUtils.getProperty(employee, "address(home).city"));

    }
}
