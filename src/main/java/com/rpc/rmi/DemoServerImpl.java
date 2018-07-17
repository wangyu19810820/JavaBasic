package com.rpc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DemoServerImpl extends UnicastRemoteObject implements DemoService {

    public DemoServerImpl() throws RemoteException {
        // 因为 UnicastRemoteObject 构造器抛出 RemoteException
        // 所以此处只能声明一个构造器并抛出对应异常
    }

    public String sayHello() throws RemoteException {
        return "hello";
    }
}
