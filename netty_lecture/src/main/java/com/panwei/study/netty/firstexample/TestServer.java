package com.panwei.study.netty.firstexample;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
public class TestServer {
    /**
     * 简单的netty
     * @param args
     */
    public static void main(String[] args) {

        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup =new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap=new ServerBootstrap();

            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    //初始化器，添加一些自己的处理器
                    .childHandler(new TestServerInitializer());

            ChannelFuture channelFuture= serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
