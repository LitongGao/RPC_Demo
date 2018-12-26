package com.litong.rpc.dao;

public class FakeDao {

    public void getFakeById(String id) {
        System.out.println("被调用了"+id);
    }
}
