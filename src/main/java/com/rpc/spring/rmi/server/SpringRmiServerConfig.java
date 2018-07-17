package com.rpc.spring.rmi.server;

import com.rpc.spring.rmi.service.SpringRmiDemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * RMI的服务器端支持配置，也可使用xml配置
 */
@Configuration
@ComponentScan("com.rpc.spring.rmi.service")
public class SpringRmiServerConfig {

    @Bean(name = "springRmiDemoService")
    public RmiServiceExporter springRmiDemoService(SpringRmiDemoService springRmiDemoService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        // 服务
        rmiServiceExporter.setService(springRmiDemoService);
        // 服务名
        rmiServiceExporter.setServiceName("SpringRmiDemoService");
        // 服务类名
        rmiServiceExporter.setServiceInterface(SpringRmiDemoService.class);
        // RMI的使用端口
        rmiServiceExporter.setRegistryPort(1199);
        return rmiServiceExporter;
    }
}
