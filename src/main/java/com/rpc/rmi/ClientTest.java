package com.rpc.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientTest {
    public static void main(String[] args) throws Exception {
        String name = "rmi.service.DemoService";
        /***************** 以下为查找服务方法一 ************/
        // 获取注册表
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        // 查找对应的服务
        DemoService service = (DemoService) registry.lookup(name);

        /***************** 以下为查找服务方法二 ************/
        // DemoService service = (DemoService) Naming.lookup(name);

        /***************** 以下为查找服务方法三 ************/
        //Context namingContext = new InitialContext();
        //DemoService service = (DemoService) namingContext.lookup("rmi:" + name);

        // 调用服务
        System.out.println(service.sayHello());
    }
}
