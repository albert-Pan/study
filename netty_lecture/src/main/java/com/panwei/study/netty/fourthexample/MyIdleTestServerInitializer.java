package com.panwei.study.netty.fourthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyIdleTestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline=ch.pipeline();
        //该处理器会在出现读或者写空闲时将事件传入下一个处理器，这里是我们自己编写的MyIdelTestServerHandler
        pipeline.addLast(new IdleStateHandler(5,5,10, TimeUnit.SECONDS));
        pipeline.addLast(new MyIdleTestServerHandler());

    }
}
