package com.panwei.study.netty.firstexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;


/**
 * 各各方法执行的时机
 * handler Added
 * channel Registered
 * channel Active
 * channelRead0 请求方法名：GET
 * 用浏览器调用由于Connection keep-alive 存在后续的需要等到时间到了才会关闭
 * channel Inactive
 * channel Unregistered
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler Added");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Registered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Active");
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if(msg instanceof  HttpRequest) {
            HttpRequest httpRequest= (HttpRequest) msg;
            System.out.println("请求方法名："+httpRequest.method().name());
            URI uri =new URI(httpRequest.uri());
            if("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求/favicon.ico");
                return;
            }
            ByteBuf content = Unpooled.copiedBuffer("Hello world", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            ctx.writeAndFlush(response);
            //服务端可以选择直接关闭
            //ctx.channel().close();
        }
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Inactive");
        super.channelInactive(ctx);
    }


    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Unregistered");
        super.channelUnregistered(ctx);
    }


}