package netty.http;

import java.net.URI;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

public class TestServerHandler extends SimpleChannelInboundHandler<HttpObject>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
		//判断msg是不是httprequest请求
		if(msg instanceof HttpRequest) {
			//pipline和handler是独立的
			System.out.println("pipline hashCode=" + ctx.pipeline().hashCode() + ",TestServerHandler=" + this.hashCode());
			
			System.out.println("msg类型=" + msg.getClass());
			System.out.println("客户端地址:" + ctx.channel().remoteAddress());
			
			HttpRequest httpRequest = (HttpRequest) msg;
			//过滤掉指定的资源
			URI uri = new URI(httpRequest.uri());
			
			if("/favicon.ico".equals(uri.getPath())) {
				System.out.println("请求了favicon.ico");
				return;
			}
		}
		//回复信息给浏览器[http协议]
		ByteBuf content = Unpooled.copiedBuffer("hello 我是服务器", CharsetUtil.UTF_8);
		FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
		response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
		response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
		//将构建好的response返回
		ctx.writeAndFlush(response);
	}
}
