package com.study.netty02.fixedLength;

import java.nio.charset.Charset;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 定长数据解决粘包问题
 * 
 * @author Administrator
 *
 */
public class Server4FiexedLength {
	// 监听线程组,监听客户端请求
	private EventLoopGroup acceptorGroup = null;
	// 处理客户端相关操作线程组,负责处理与客户端的数据通讯
	private EventLoopGroup clientGroup = null;

	private ServerBootstrap bootstrap = null;

	public Server4FiexedLength() {
		init();
	}

	public static void main(String[] args) {

		ChannelFuture future = null;
		Server4FiexedLength server = null;

		try {

			server = new Server4FiexedLength();
			future = server.doAccept(9999);
			System.out.println("server started");

			future.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 回收资源
			if (null != future) {
				try {
					future.channel().closeFuture().sync();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (null != server) {
				server.release();
			}
		}
	}
	
	public void release() {
		this.acceptorGroup.shutdownGracefully();
		this.clientGroup.shutdownGracefully();
	}

	public ChannelFuture doAccept(int port) throws Exception {

		/*
		 * childHandler是服务端的Bootstrap独有的方法,是用于提供处理对象的 可以一次性增加多个处理逻辑,是类似责任链模式的处理方式
		 * 
		 * ChannelInitializer: 用于提供处理器的一个模型对象。 其中定义了一个方法initChannel,是用于初始化处理逻辑责任链条的
		 * 可以保证服务端的Bootstrap只初始化一次处理器,尽量提供处理逻辑的重用 避免反复的创建处理器对象，节约资源开销
		 */
		bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				// 数据分隔符
				ByteBuf delimiter = Unpooled.copiedBuffer("$E$".getBytes());
				ChannelHandler[] acceptorHandlers = new ChannelHandler[3];
				// 定长Handler,通过构造参数设置消息长度。发送的消息长度不足可以使用空格补全
				acceptorHandlers[0] = new FixedLengthFrameDecoder(3);
				// 字符串解码器Handler,会自动处理channelRead方法的msg参数,将ByteBuf类型的数据转换为字符串
				acceptorHandlers[1] = new StringDecoder(Charset.forName("UTF-8"));
				acceptorHandlers[2] = new Server4FiexedLengthHandler();
				ch.pipeline().addLast(acceptorHandlers);
			}
		});

		// bind方法-绑定监听端口的,ServerBootstrap可以绑定多个监听端口,多次调用bind即可
		// sync:启动监听逻辑,会返回一个ChannelFuture,返回结果代表的是监听成功后的未来结果
		// 可以使用ChannelFuture实现后续的服务器和客户端的交互
		ChannelFuture future = bootstrap.bind(port).sync();
		return future;
	}

	private void init() {
		// 初始化线程组,构建线程组的时候,如果不传递参数,则默认构建线程组线程数是CPU核心数量
		// 初始化为1说明是单线程
		acceptorGroup = new NioEventLoopGroup();
		clientGroup = new NioEventLoopGroup();
		// 初始化服务配置
		bootstrap = new ServerBootstrap();
		// 绑定线程组
		bootstrap.group(acceptorGroup, clientGroup);
		// 设定通讯模式为NIO,也就是同步非阻塞模式
		bootstrap.channel(NioServerSocketChannel.class);
	}
}
