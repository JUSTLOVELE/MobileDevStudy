package netty.simple;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

	public static void main(String[] args) throws InterruptedException {
		
		//bossGroup只是处理连接请求,真正的和客户端业务处理会交给workGroup处理
		//两个都是无限循环
		//默认实际cpu核数*2,实际跑的时候会循环的用线程去接client
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		
		try {
			//创建服务器端的启动对象,配置参数
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workGroup)
					.channel(NioServerSocketChannel.class)
				  	.option(ChannelOption.SO_BACKLOG, 128)//设置现场队列得到连接个数
				  	.childOption(ChannelOption.SO_KEEPALIVE, true)//保持活动连接状态
				  	.childHandler(new ChannelInitializer<SocketChannel>() {
				  		//给pipline设置处理器
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new NettyServerHandler());
						}
				  		
					})//给我们的workgroup的eventGroup对应的普通设置处理器
				  	; 
			System.out.println("...服务器is ready...");
			//绑定一个端口并且同步生成了一个channelfuture对象
			ChannelFuture cf = bootstrap.bind(6668).sync();
			//给cf注册监听器,监控我们关心的事件
			cf.addListener(new ChannelFutureListener() {
				
				@Override
				public void operationComplete(ChannelFuture future) throws Exception {
					
					if(cf.isSuccess()) {
						System.out.println("监听6668成功");
					}else {
						System.out.println("监听6668失败");
					}
				}
			});
			//对关闭通道进行监听,不是启动就关闭了
			cf.channel().closeFuture().sync();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
