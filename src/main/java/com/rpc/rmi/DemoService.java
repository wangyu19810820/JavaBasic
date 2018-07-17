package com.rpc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DemoService extends Remote {

    String sayHello() throws RemoteException;
}
