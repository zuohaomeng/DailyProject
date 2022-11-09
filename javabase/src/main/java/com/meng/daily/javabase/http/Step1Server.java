package com.meng.daily.javabase.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * 面向对象分装
 *
 * @author ZuoHao
 * @date 2022/9/20
 */
public class Step1Server {
    ServerSocket serverSocket;
    Function<String, String> handler;

    public Step1Server(Function<String, String> handler) {
        this.handler = handler;
    }

    //监听一个队列，Pending queue
    public void listen(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            accept();
        }
    }

    void accept() throws IOException {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder requestBuilder = new StringBuilder();
            String line = "";
            while (!(line = br.readLine()).isEmpty()) {
                requestBuilder.append(line).append("\n");
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String response = handler.apply(requestBuilder.toString());
            bw.write(response);
            bw.flush();
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Step1Server step1Server = new Step1Server(req -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "HTTP/1.1 200 ok\n\n" +
                    "Hello step1!\n";
        });
        step1Server.listen(8001);
    }
}
