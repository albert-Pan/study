package com.panwei.study.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer 获取文件内容映射到内存，可以直接在内存进行修改
 */
public class NioTest8 {
    public static void main(String[] args)throws Exception {
        ClassLoader classLoader =  NioTest7.class.getClassLoader();
        File inputFile = new File(classLoader.getResource("test.txt").getFile());
        RandomAccessFile randomFile=new RandomAccessFile(inputFile,"rw");
        FileChannel fileChannel=randomFile.getChannel();
        MappedByteBuffer mappedByteBuffer=fileChannel.map(FileChannel.MapMode.READ_WRITE,0,5);
        mappedByteBuffer.put(0,(byte)'a');
        mappedByteBuffer.put(3,(byte)'b');
        randomFile.close();



    }

}
