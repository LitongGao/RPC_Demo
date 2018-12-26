package com.litong.rpc.request;

import com.litong.rpc.info.RpcInfo;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class ServerHanlder implements Runnable {

    private Socket socket;
    public ServerHanlder(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcInfo rpcInfo = (RpcInfo) objectInputStream.readObject();
            Class clazz = Class.forName(rpcInfo.getPackageName()+"."+rpcInfo.getClazzName());
            Class[] classes = new Class[rpcInfo.getParams().length];
            for (int i = 0; i < classes.length; i++) {
                classes[i] = rpcInfo.getParams()[i].getClass();
            }
            System.out.println("from server:"+rpcInfo.getMethodName());
            Method method = clazz.getMethod(rpcInfo.getMethodName(),classes);
            method.invoke(clazz.newInstance(),rpcInfo.getParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
