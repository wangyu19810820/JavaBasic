package com.rpc.spring.rmi.service;

/**
 * 当Spring封装RMI后，其Service无需继承Remote接口
 * 只需用普通的Service就可以
 */
public interface SpringRmiDemoService {

    String sayHello();
}
