package com.panwei.study.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader =  NioTest2.class.getClassLoader();
        File inputFile = new File(classLoader.getResource("input.txt").getFile());
        File outputFile = new File(classLoader.getResource("output.txt").getFile());
        FileInputStream inputStream=new FileInputStream(inputFile);
        RandomAccessFile outputStream = new RandomAccessFile(outputFile, "rw");
        FileChannel inputChannel=inputStream.getChannel();
        FileChannel outputChannel=outputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        while(true){
            /**
             *  如果注释掉会出现的问题
             *  无限循环写入
             *  比如第一次读入5 l=1024 p=5, flip 后 l=5  p=0  写入后 l=5  p=5
             *  第二次循环读入0 l=5  p=5    flip 后 l=5  p=0  写入后 l=5  p=5
             *  第三次循环读入0 l=5  p=5    flip 后 l=5  p=0  写入后 l=5  p=5
             *  。。。。。。。。。。。
             */
            byteBuffer.clear();
            int read=inputChannel.read(byteBuffer);
            System.out.println("read="+read);
            if(-1==read){
                break;
            }
            byteBuffer.flip();
            //最后写到了build目录下的resources里
            outputChannel.write(byteBuffer);
        }
        inputChannel.close();
        outputChannel.close();
    }
}
