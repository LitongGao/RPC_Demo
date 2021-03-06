package com.litong.rpc.request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerRequest {

    public void publishServer() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            ServerSocket serverSocket = new ServerSocket(9909);
            while (true) {
                System.out.println("wait for ...");
                Socket accept = serverSocket.accept();
                System.out.println("conn successful");
                executorService.execute(new ServerHanlder(accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
