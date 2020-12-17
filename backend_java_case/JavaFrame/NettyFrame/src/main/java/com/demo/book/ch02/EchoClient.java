package com.demo.book.ch02;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class EchoClient {

	private final String host;
	
	private final int port;
	
	public EchoClient(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public static void main(String[] args) throws Exception {
		
		new EchoClient("localhost", 9002).start();
	}
	
	public void start() throws Exception {
		
		EventLoopGroup group = new NioEventLoopGroup();
		
		try {
			//专用于客户端的引导
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
			.remoteAddress(new InetSocketAddress(host, port))
			.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					//EchoServerHandler被标注为@Sharable,所以我们总是可以使用同样的实例
					ch.pipeline().addLast(new EchoClientHandler());
				}
			});
			
			ChannelFuture f = b.connect(host, port).sync();
			f.channel().closeFuture().sync();
			
		} finally {
			group.shutdownGracefully().sync();
		}
	}
	
}
