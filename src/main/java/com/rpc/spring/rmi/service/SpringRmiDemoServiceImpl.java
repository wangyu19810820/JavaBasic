package com.rpc.spring.rmi.service;

import org.springframework.stereotype.Component;

/**
 * 当Spring封装RMI后，其Service无需继承Remote接口
 * 只需用普通的Service就可以
 */
@Component
public class SpringRmiDemoServiceImpl implements SpringRmiDemoService {

    @Override
    public String sayHello() {
        return "SpringRmiDemoService:hello";
    }
}
