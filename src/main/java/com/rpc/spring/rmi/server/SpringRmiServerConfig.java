package com.rpc.spring.rmi.server;

import com.rpc.spring.rmi.service.SpringRmiDemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
@ComponentScan("com.rpc.spring.rmi.service")
public class SpringRmiServerConfig {

    @Bean
    public RmiServiceExporter rmiExporter(SpringRmiDemoService springRmiDemoService) {
        System.out.println(springRmiDemoService.sayHello());
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(springRmiDemoService);
        rmiServiceExporter.setServiceName("aa");
        rmiServiceExporter.setServiceInterface(SpringRmiDemoService.class);
//        rmiServiceExporter.setRegistryPort(1199);
        return rmiServiceExporter;
    }
}
