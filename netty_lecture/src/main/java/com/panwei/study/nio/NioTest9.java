package com.panwei.study.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class NioTest9 {

    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        SocketAddress address=new InetSocketAddress(8899);
        serverSocketChannel.bind(address);
        SocketChannel  socketChannel= serverSocketChannel.accept();
        int msgLength=2+3+4;
        ByteBuffer [] buffers=new ByteBuffer[3];
        buffers[0]=ByteBuffer.allocate(2);
        buffers[1]=ByteBuffer.allocate(3);
        buffers[2]=ByteBuffer.allocate(4);


        while (true){
            long readlength=0;
            while (readlength<msgLength){
              readlength=+socketChannel.read(buffers);
            }
            Arrays.asList(buffers).forEach(byteBuffer -> {
                byteBuffer.flip();
            });
            while (true){
                Arrays.asList(buffers).stream().forEach(byteBuffer -> {

                });

            }


        }


    }
}
