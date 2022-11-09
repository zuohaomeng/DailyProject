package com.meng.daily.javabase.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZuoHao
 * @date 2022/9/20
 */
public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            //Blocking
            Socket socket = serverSocket.accept();
            System.out.println("A socket created");
            BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(socket.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while (!(line = br.readLine()).isEmpty()) {
                sb.append(line).append("\n");
            }
            System.out.println(sb);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("HTTP/1.1 200 ok\n\n" +
                    "Hello world!\n");
            bw.flush();
            socket.close();
        }
    }
}
