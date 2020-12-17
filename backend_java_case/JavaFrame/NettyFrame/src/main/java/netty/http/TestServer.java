package netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestServer {

	public static void main(String[] args) {
		
		NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 128)//设置现场队列得到连接个数
				.childOption(ChannelOption.SO_KEEPALIVE, true)//保持活动连接状态
				.childHandler(new TestServerInitalizer());
			ChannelFuture channelFuture = serverBootstrap.bind(13001).sync();
			System.out.println("启动成功");
			channelFuture.channel().closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
