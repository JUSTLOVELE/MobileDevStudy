package com.study.netty02.fixedLength;

import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class Client4FixedLength {
	//处理请求和处理服务器响应的线程组
	private EventLoopGroup group = null;
	//服务启动相关配置信息
	private Bootstrap bootstrap = null;
	
	public Client4FixedLength() {
		init();
	}
	
	public static void main(String[] args) {
		
		Client4FixedLength client = null;
		ChannelFuture future = null;
		
		try {
			
			client = new Client4FixedLength();
			future = client.doRequest("localhost", 9999);
			
			Scanner s = null;
			
			while(true) {
				
				s = new Scanner(System.in);
				System.out.print("Enter message send to server:");
				System.out.println("\n");
				String line = s.nextLine();
				future.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
				TimeUnit.SECONDS.sleep(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void release() {
		this.group.shutdownGracefully();
	}
	
	public ChannelFuture doRequest(String host, int port) throws Exception {
		
		this.bootstrap.handler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {

				ChannelHandler[] handlers = new ChannelHandler[3];
				//定长Handler,通过构造参数设置消息长度。发送的消息长度不足可以使用空格补全
				handlers[0] = new FixedLengthFrameDecoder(3);
				//字符串解码器Handler,会自动处理channelRead方法的msg参数,将ByteBuf类型的数据转换为字符串
				handlers[1] = new StringDecoder(Charset.forName("UTF-8"));
				handlers[2] = new Client4FixedLengthHandler();
				ch.pipeline().addLast(handlers);
			}
		});
		
		ChannelFuture future = this.bootstrap.connect(host, port).sync();
		return future;
	}
	
	private void init() {
		
		group = new NioEventLoopGroup();
		bootstrap = new Bootstrap();
		bootstrap.group(group).channel(NioSocketChannel.class);
	}
}
