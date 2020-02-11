package com.panwei.study.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader =  NioTest2.class.getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());

        FileInputStream inputStream=new FileInputStream(file);
        FileChannel fileChannel=inputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while(byteBuffer.remaining()>0){
            byte b=byteBuffer.get();
            System.out.println("character:" +(char)b);
        }

        inputStream.close();

    }
}
