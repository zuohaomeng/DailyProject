package com.meng.daily.javabase.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO
 *
 * @author ZuoHao
 * @date 2022/9/20
 */
public class Step3Server {
    ServerSocketChannel ssc;

    public Step3Server() {
    }

    //监听一个队列，Pending queue
    public void listen(int port) throws IOException {
        ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(port));
        //非阻塞
        ssc.configureBlocking(false);
        Selector selector = Selector.open();
        ssc.register(selector, ssc.validOps(), null);
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 16);
        for (;;) {
            int numOfKey = selector.select();//阻塞
            if(numOfKey<=0){
                //xxxxx
                continue;
            }
            Set<SelectionKey> selectKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (key.isAcceptable()) { //如果是accept操作
                    SocketChannel channel = ssc.accept();
                    if (channel == null) {
                        continue;
                    }
                    //Kernel -> mmap(buffer) -> Channel -> User(Buffer)
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                } else {
                    SocketChannel channel = (SocketChannel) key.channel();
                    buffer.clear();
                    channel.read(buffer);//User(Buffer)
                    String request = new String(buffer.array());
                    System.out.println(request);
                    buffer.clear();
                    buffer.put("HTTP/1.1 200 OK\n\nHello\n".getBytes(StandardCharsets.UTF_8));
                    buffer.flip();
                    channel.write(buffer);
                    channel.close();
                }
            }
        }
    }
}
