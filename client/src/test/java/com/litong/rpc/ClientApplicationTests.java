package com.litong.rpc;

import com.litong.rpc.info.RpcInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

	@Test
	public void contextLoads() {
		RpcInfo rpcInfo = new RpcInfo();
		rpcInfo.setPackageName("com.litong.rpc.server.dao");
		rpcInfo.setClazzName("OrderDao");
		rpcInfo.setMethodName("getOrderById");
		Object[] objects = new Object[]{"temp1"};
		rpcInfo.setParams(objects);
		try {
			Socket socket = new Socket("127.0.0.1",9909);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(rpcInfo);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

