package com.rpc.spring.rmi.client;

import com.rpc.spring.rmi.service.SpringRmiDemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientDemo {

    public static void main(String[] args) {
        try {
            AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(SpringRmiClientConfig.class);
            SpringRmiDemoService service = context.getBean(SpringRmiDemoService.class);
            System.out.println(service.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
