package com.panwei.study.nio;

import java.nio.ByteBuffer;

/**
 * slice 产生的buffer是共享的，对任意一个buffer做修改另外的buffer也会变化
 *另外常用的方法asReadOnlyBuffer()产生只读的buffer
 */
public class NioTest6 {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(10);
        for (int i = 0; i <10 ; i++) {
            buffer.put((byte)i);
        }
        buffer.position(2);
        buffer.limit(5);
        ByteBuffer sliceBuffer=buffer.slice();

        for (int i = 0; i <sliceBuffer.capacity() ; i++) {
            byte b=sliceBuffer.get(i);
            b*=2;
            sliceBuffer.put(i,b);
        }
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }


    }
}
