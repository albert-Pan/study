package com.panwei.study.netty.thirdexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.UUID;

/**
 * 自己定义的处理器
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
    private  static ChannelGroup  channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        //先广播后加入
        channelGroup.writeAndFlush("服务器-"+channel.remoteAddress()+" 加入\n");

        channelGroup.add(channel);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        System.out.println(channel.remoteAddress()+"  上线");

    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.forEach(ch-> {
            if(channel!=ch){
                ch.writeAndFlush(channel.remoteAddress()+"发送消息:"+msg+"\n");
            }else {
                ch.writeAndFlush("[自己] :"+msg+"\n");
            }
        });


    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        System.out.println(channel.remoteAddress()+"  下线");
    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        //先广播后加入
        channelGroup.writeAndFlush("服务器-"+channel.remoteAddress()+" 离开\n");

        //调不调用都可以netty会自动移除
        channelGroup.remove(channel);
    }



    /**
     * 出现异常关闭连接
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
