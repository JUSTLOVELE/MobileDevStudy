package com.demo.book.ch02;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

	private final int port;
	
	public EchoServer(int port) {
		this.port = port;
	}
	
	public static void main(String[] args) {
		
		try {
			new EchoServer(9002).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() throws Exception {
		
		final EchoServerHandler serverHandler = new EchoServerHandler();
		//1.创建EventLoopGroup
		EventLoopGroup group = new NioEventLoopGroup();
		
		try {
			//2 .  创建ServerBootstrap,专用于服务器端
			ServerBootstrap b = new ServerBootstrap();
			//3.指定所使用的NIO传输Channel,并指定端口设置套接字地址
			b.group(group).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port))
			//4.添加一个EchoServerHandler到子Channel的ChannelPipeline
			.childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					//EchoServerHandler被标注为@Sharable,所以我们总是可以使用同样的实例
					ch.pipeline().addLast(serverHandler);
				}
			});
			//5.异地绑定服务器;调用sync()方法阻塞等待直到绑定完成
			ChannelFuture f = b.bind(port).sync();
			System.out.println("echoserver启动成功");
			//6.获取Channel的CloseFuture,并且阻塞当前线程直到它完成
			f.channel().closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//7.关闭EventLoopGroup释放所有的资源
			group.shutdownGracefully().sync();
		}
	}
}
