package com.study.netty01.first;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 显然实现接口ChannelHandler也是可以的,但是接口方法太多,我们需要的没那么多
 * @author Administrator
 *
 */
public class Server4HelloWorldHandler extends ChannelInboundHandlerAdapter {
	
	/**
	 * 用户处理读取数据请求的逻辑
	 * ctx: 上下文对象,其中包含于客户端建立连接的所有资源
	 * msg: 读取到的数据.默认类型是ByteBuf,ByteBuf是netty自定义的,是对byteBuffer的封装
	 * 
	 * @throws UnsupportedEncodingException 
	 */
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
		
		ByteBuf readBuffer = (ByteBuf) msg;
		byte[] tempDatas = new byte[readBuffer.readableBytes()];
		readBuffer.readBytes(tempDatas);
		String message = new String(tempDatas, "UTF-8");
		System.out.println("from client: " + message);
		
		if("exit".equals(message)) {
			ctx.close();
			return;
		}
		
		String line = "server message to client";
		//写操作自动释放缓存,避免内存溢出问题
		ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
		//如果是用write方法,则不会刷新缓存,缓存中的数据不会发送到客户端,必须再次调用flush方法才行
		//ctx.wtite
		//ctx.flush
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		//将未决消息冲刷到远程节点,并且关闭该Channel
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
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
