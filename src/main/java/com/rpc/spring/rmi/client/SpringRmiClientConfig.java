package com.rpc.spring.rmi.client;

import com.rpc.spring.rmi.service.SpringRmiDemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class SpringRmiClientConfig {

    @Bean
    public RmiProxyFactoryBean springRmiDemoService() {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost:/aa");
        rmiProxy.setServiceInterface(SpringRmiDemoService.class);
        return rmiProxy;
    }
}
