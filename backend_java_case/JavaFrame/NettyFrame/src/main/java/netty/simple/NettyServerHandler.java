package netty.simple;

import java.util.concurrent.TimeUnit;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/*
 * 自定义一个handler需要基层netty规定好的某个handlerAdapter
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
	
		ctx.close();
	}	

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
//		System.out.println("服务器读取现场:" + Thread.currentThread().getName());
//		System.out.println("server ctx = " + ctx);
//		System.out.println("channel和pipeline的关系:");
//		Channel channel = ctx.channel();
//		ChannelPipeline pipeline = ctx.pipeline();//本质是一个双向链接,出栈入栈
//		
//		//将msg转成一个bytebuf
//		ByteBuf buf = (ByteBuf) msg;
//		System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
//		System.out.println("客户端ip:" + ctx.channel().remoteAddress());
		
		//假如这里我们有一个非常耗时的时间业务->异步执行->提交该channel对应的NIOEventLoop的taskQueue
		
		//解决方案1 用户程序自定义普通任务
		ctx.channel().eventLoop().execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					
					Thread.sleep(10*1000);
					ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~用户自定义任务", CharsetUtil.UTF_8));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		ctx.channel().eventLoop().schedule(new Runnable() {
			
			@Override
			public void run() {
				try {
					
					ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~用户自定义任务333", CharsetUtil.UTF_8));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, 5, TimeUnit.SECONDS);
		
		System.out.println("go on...");
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		//将数据写入到缓冲并刷新
		ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~", CharsetUtil.UTF_8));
	}
}
