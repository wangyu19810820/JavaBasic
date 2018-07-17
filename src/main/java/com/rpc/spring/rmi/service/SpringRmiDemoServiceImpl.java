package com.rpc.spring.rmi.service;

import org.springframework.stereotype.Component;

@Component
public class SpringRmiDemoServiceImpl implements SpringRmiDemoService {

    @Override
    public String sayHello() {
        return "SpringRmiDemoService:hello";
    }
}
