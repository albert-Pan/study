package com.panwei.study.netty.fourthexample;

import io.netty.channel.*;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * 自己定义的处理器
 */
public class MyIdleTestServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent= (IdleStateEvent) evt;
            IdleState idleState= idleStateEvent.state();
            String eventType=null;
            switch (idleState){
                case READER_IDLE:
                    eventType="读空闲";
                    break;
                case WRITER_IDLE:
                    eventType="写空闲";
                    break;
                case ALL_IDLE:
                    eventType="读写空闲";
                    break;
            }
            System.out.println(eventType);

        }
    }
}
