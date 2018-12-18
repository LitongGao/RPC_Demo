package com.litong.rpc.request;

import com.litong.rpc.info.RpcInfo;

import java.io.ObjectInputStream;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
