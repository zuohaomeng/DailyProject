package com.meng.daily.javabase.http;

import org.springframework.util.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * 优化线程模型
 *
 * @author ZuoHao
 * @date 2022/9/20
 */
public class Step2Server {
    AtomicInteger atomicInteger = new AtomicInteger(0);
    ServerSocket serverSocket;
    Function<String, String> handler;

    public Step2Server(Function<String, String> handler) {
        this.handler = handler;
    }

    //监听一个队列，Pending queue
    public void listen(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            accept();
        }
    }

    void accept() {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket finalSocket = socket;
        new Thread(() -> {
            try {
                System.out.println(atomicInteger.incrementAndGet());
                this.handler(finalSocket);
                atomicInteger.decrementAndGet();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    void handler(Socket socket) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(socket.getInputStream())));
            StringBuilder requestBuilder = new StringBuilder();
            String line = "";
            while (!StringUtils.isEmpty((line = br.readLine()))) {
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
        Step2Server step2Server = new Step2Server(req -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "HTTP/1.1 200 ok\n\n" +
                    "Hello step2!\n";
        });
        step2Server.listen(8002);
    }
}
