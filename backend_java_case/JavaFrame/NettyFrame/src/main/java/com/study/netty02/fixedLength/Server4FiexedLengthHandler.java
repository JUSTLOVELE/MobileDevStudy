package com.study.netty02.fixedLength;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Server4FiexedLengthHandler extends ChannelInboundHandlerAdapter {
	
	/**
	 * 用户处理读取数据请求的逻辑
	 * ctx: 上下文对象,其中包含于客户端建立连接的所有资源
	 * msg: 读取到的数据.默认类型是ByteBuf,ByteBuf是netty自定义的,是对byteBuffer的封装
	 * 
	 * @throws UnsupportedEncodingException 
	 */
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
		
		String message = msg.toString();
		System.out.println("from client:" + message);
		String line = "ok ";
		ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		//将未决消息冲刷到远程节点,并且关闭该Channel
		//ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
	}
	
	
	/**
	 * 异常处理逻辑,当客户端异常退出的时候也会运行
	 * ChannelHandlerContext关闭,也代表当前与客户端连接的资源关闭.
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		
		cause.printStackTrace();
		ctx.close();
	}
}
