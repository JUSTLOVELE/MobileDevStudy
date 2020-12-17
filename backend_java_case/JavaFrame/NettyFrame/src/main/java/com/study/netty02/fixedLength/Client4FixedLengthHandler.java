package com.study.netty02.fixedLength;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class Client4FixedLengthHandler extends ChannelInboundHandlerAdapter {

	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
		
		
		try {
			String message = msg.toString();
			System.out.println("from server:" + message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ReferenceCountUtil.release(msg);
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		
		cause.printStackTrace();
		ctx.close();
	}


}
