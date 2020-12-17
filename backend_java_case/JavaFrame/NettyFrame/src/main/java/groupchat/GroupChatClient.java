package groupchat;

import java.util.Scanner;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class GroupChatClient {

	private final String host;
	
	private final int port;
	
	public GroupChatClient(String host, int port) {
		
		this.host = host;
		this.port = port;
	}
	
	public void run() throws InterruptedException {

		EventLoopGroup group = new NioEventLoopGroup();
		
		try {
			
			Bootstrap bootstrap = new Bootstrap()
					.group(group)
					.channel(NioSocketChannel.class)
					.handler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ChannelPipeline pipeline = ch.pipeline();
							pipeline.addLast("decoder", new StringDecoder());
							pipeline.addLast("encoder", new StringEncoder());
							pipeline.addLast(new GroupChatClientHandler());
						}
					});
			
			ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
			Channel channel = channelFuture.channel();
			System.out.println("----------------" + channel.localAddress() + "------------") ;
			Scanner scanner = new Scanner(System.in);
			
			while(scanner.hasNextLine()) {
				
				String msg = scanner.nextLine();
				channel.writeAndFlush(msg + "\r\n");
			}
			
		} finally {
			group.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new GroupChatClient("localhost", 7000).run();;
	}
}
