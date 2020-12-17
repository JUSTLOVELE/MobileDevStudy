package netty.heartbeat;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class MyServer {

	public static void main(String[] args) {
		//
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.handler(new LoggingHandler(LogLevel.INFO))
				.childHandler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						
						ChannelPipeline pipeline = ch.pipeline();
						/**
						 * 1.IdleStateHandler 是netty提供处理空闲状态的处理器
						 *  long readerIdleTime: 表示多长时间没有读,就会发现一个心跳检测包检测是否连接
						 *  long writerIdleTime: 表示多长时间没有写,就会发送一个心跳检测包检测是否连接
						 *  long allIdleTime: 表示多长时间没有读写就会发送一个心跳检测包检测是否连接
						 */
						pipeline.addLast(new IdleStateHandler(3, 5, 7, TimeUnit.SECONDS));
						pipeline.addLast(new MyServerHandler());
					}
				});
			//启动服务器
			ChannelFuture channelFuture = serverBootstrap.bind(7001).sync();
			channelFuture.channel().closeFuture().sync();		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
