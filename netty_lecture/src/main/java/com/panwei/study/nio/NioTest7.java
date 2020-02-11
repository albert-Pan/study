package com.panwei.study.nio;

import sun.nio.ch.DirectBuffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * HeapByteBuffer 和普通的java对象其实没有多大区别，都是直接在堆上分配内存
 *
 *DirectBuffer 分配内存是通过 native  是在堆外本地内存分配的 c++ malloc
 * 在父类Buffer中 有一个 address  相当于一个堆外内存的引用
 *
 *
 * 为什么不放在堆内？
 * HeapByteBuffer 在处理数据时操作系统还会在拷贝一份数据到堆外，由这部分数据直接和其交互
 * 会多出一次拷贝。而直接使用DirectBuffer 就省去了一次拷贝
 *
 * IO设备在工作时这片内存不能变化，而我们的JVM会进行GC此时对象是可能压缩内存会变化的
 * 所以需要拷贝一次到堆外内存
 *
 */
public class NioTest7 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader =  NioTest7.class.getClassLoader();
        File outputFile = new File(classLoader.getResource("output.txt").getFile());
        File inputFile = new File(classLoader.getResource("input.txt").getFile());
        FileInputStream inputStream=new FileInputStream(inputFile);
        FileChannel inputChannel=inputStream.getChannel();
        RandomAccessFile outputStream = new RandomAccessFile(outputFile, "rw");
        FileChannel outputChannel=outputStream.getChannel();


        /**
         * 这里使用了allocateDirect 返回的是一个
         * DirectBuffer
         */
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(1024);

        while(true){
            byteBuffer.clear();
            int read=inputChannel.read(byteBuffer);
            if(read==-1){
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
