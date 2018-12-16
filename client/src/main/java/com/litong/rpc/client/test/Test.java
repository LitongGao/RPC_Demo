package com.litong.rpc.client.test;

import com.litong.rpc.client.info.RpcInfo;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.Socket;

public class Test {


    public static void main(String[] args) {

        RpcInfo rpcInfo = new RpcInfo();
        rpcInfo.setPackageName("com.litong.rpc.client.dao");
        try {
            Socket socket = new Socket("127.0.0.1",9909);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
