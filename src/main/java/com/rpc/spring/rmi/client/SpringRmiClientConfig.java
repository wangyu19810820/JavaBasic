package com.rpc.spring.rmi.client;

import com.rpc.spring.rmi.service.SpringRmiDemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * RMI的客户端支持配置，也可使用xml配置
 */
@Configuration
public class SpringRmiClientConfig {

    // 客户端可以像普通Service一样，使用远程Service的方法
    @Bean
    public RmiProxyFactoryBean springRmiDemoService() {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost:1199/SpringRmiDemoService");
        rmiProxy.setServiceInterface(SpringRmiDemoService.class);
        return rmiProxy;
    }
}
