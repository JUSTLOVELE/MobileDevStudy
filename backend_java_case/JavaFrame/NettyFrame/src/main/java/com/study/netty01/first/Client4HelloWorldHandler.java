package com.study.netty01.first;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class Client4HelloWorldHandler extends ChannelInboundHandlerAdapter {
	
	/**
	 * 用户处理读取数据请求的逻辑
	 * ctx: 上下文对象,其中包含于客户端建立连接的所有资源
	 * msg: 读取到的数据.默认类型是ByteBuf,ByteBuf是netty自定义的,是对byteBuffer的封装
	 * 
	 * @throws UnsupportedEncodingException 
	 */
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
		
		
		try {
			ByteBuf readBuffer = (ByteBuf) msg;
			byte[] tempDatas = new byte[readBuffer.readableBytes()];
			readBuffer.readBytes(tempDatas);
			System.out.println("from server: " + new String(tempDatas, "UTF-8"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ReferenceCountUtil.release(msg);
		}
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
