package com.panwei.study.netty.thirdexample;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 简单的客户端代码
 */
public class MyChatClient {


    public static void main(String[] args) throws Exception {
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
        try {
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer());
           ChannelFuture channelFuture= bootstrap.connect("localhost",8899).sync();
           Channel channel=channelFuture.channel();
           //读入标准的输入流
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            for (;;){
                channel.writeAndFlush(br.readLine()+"\r\n");
            }
        }finally {
            eventLoopGroup.shutdownGracefully();
        }



    }


}
