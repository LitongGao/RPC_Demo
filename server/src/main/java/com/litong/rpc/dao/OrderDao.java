package com.litong.rpc.dao;

import com.litong.rpc.anno.RpcClass;
import com.litong.rpc.anno.RpcMethod;


@RpcClass
public class OrderDao {

    @RpcMethod
    public void getOrderById(String id) {
        System.out.println("Id被调用了"+id);
    }

    public void getOrderByName(String name) {
        System.out.println("Name被调用了" + name);
    }
}
