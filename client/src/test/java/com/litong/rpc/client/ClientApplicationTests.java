package com.litong.rpc.client;

import com.litong.rpc.client.info.RpcInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.Socket;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

	@Test
	public void contextLoads() {
		RpcInfo rpcInfo = new RpcInfo();
		rpcInfo.setPackageName("com.litong.rpc.client.dao");
		try {
			Socket socket = new Socket("127.0.0.1",9909);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

