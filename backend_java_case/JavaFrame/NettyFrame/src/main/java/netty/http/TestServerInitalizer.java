package netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitalizer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		//向管道加入处理器
		//得到管道
		ChannelPipeline pipeline = ch.pipeline();
		//加入一个netty提供的httpServerCodec codec ->[coder - decoder]
		//1.HttpServerCodec是Netty提供的处理http的编-解码处理器
		pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
		pipeline.addLast("MyHttpServerHandler", new TestServerHandler());
	}
}
