package com.demo.book.ch02;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.util.CharsetUtil;
import io.netty.channel.ChannelHandlerContext;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.SimpleChannelInboundHandler;

@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		//当被通知channel是活跃时发送一条消息
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks", CharsetUtil.UTF_8));
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		System.out.println("Client received: " + msg.toString(CharsetUtil.UTF_8));
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		
		cause.printStackTrace();
		ctx.close();
	}

}
