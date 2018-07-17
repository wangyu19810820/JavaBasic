package com.rpc.spring.rmi.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerDemo {

    public static void main(String[] args) {
        try {
            AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(SpringRmiServerConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
