package com.rpc.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerTest {

    public static void main(String[] args) throws Exception{
        String name = "rmi.service.DemoService";
        // 创建服务
        DemoService service = new DemoServerImpl();

        // 创建本机 1099 端口上的 RMI 注册表
        Registry registry1 = LocateRegistry.createRegistry(1099);

        /***************** 以下为注册方法一 ************/
        // 将服务绑定到注册表中
        registry1.bind(name, service);

        /***************** 以下为注册方法二 ************/
        // Naming.bind(name, service);

        /***************** 以下为注册方法三 ************/
        //Context namingContext = new InitialContext();
        //namingContext.bind("rmi:" + name, service); // 此方式 name 需要以 rmi: 开头
    }
}
