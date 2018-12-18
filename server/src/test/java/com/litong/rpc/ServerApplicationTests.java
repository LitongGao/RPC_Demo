package com.litong.rpc;

import com.litong.rpc.request.ServerRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

    @Test
    public void contextLoads() {
        ServerRequest serverRequest = new ServerRequest();
        serverRequest.publishServer();
    }

}

