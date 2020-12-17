package com.study.netty01.first;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 *    客户端是请求的发起者,不需要监听。
 * 值需要定义唯一的一个线程组即可
 * @author Administrator
 *
 */
public class Client4HelloWorld {

	private EventLoopGroup group = null;
	
	private Bootstrap bootstrap = null;
	
	public Client4HelloWorld() {
		init();
	}
	
	public static void main(String[] args) {
		
		Client4HelloWorld client = null;
		ChannelFuture future = null;
		
		try {
			
			client = new Client4HelloWorld();
			future = client.doRequest("localhost", 9999, new Client4HelloWorldHandler());
			
			Scanner s = null;
			
			while(true) {
				
				s = new Scanner(System.in);
				System.out.println("Enter message send to server");
				String line = s.nextLine();
				
				if("exit".equals(line)) {
					
					future.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")))
					//addListener:增加监听,当某条件满足的时候,触发监听器
					//ChannelFutureListener.Close: 关闭监听器,代表ChannelFuture执行返回后关闭监听
					.addListener(ChannelFutureListener.CLOSE);
					break;
				}
				
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
	
	public ChannelFuture doRequest(String host, int port, final ChannelHandler... handlers) throws Exception {
		
		/*
		 * 客户端的Bootstrap没有childHandler方法，只有handler方法。
		 * 方法含义等同ServerBootstrap中的childHandler方法
		 * 服务器必须绑定绑定处理器，必须调用childHandler方法
		 */
		this.bootstrap.handler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
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
