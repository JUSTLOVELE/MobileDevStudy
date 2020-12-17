package netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class MyServerHandler extends ChannelInboundHandlerAdapter {

	/**
	 * ctx: 上下文
	 * evt: 事件
	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		
		if(evt instanceof IdleStateEvent) {
			//将evt向下转型IdleStateEvent
			IdleStateEvent event = (IdleStateEvent) evt;
			String eventType = null;
			
			if(evt instanceof IdleStateEvent) {
				
				switch (event.state()) {
				case READER_IDLE:
					eventType = "读空闲";
					break;
				case WRITER_IDLE:
					eventType = "写空闲";
					break;
				case ALL_IDLE:
					eventType = "读写空闲";
				}
			}
			
			System.out.println(ctx.channel().remoteAddress() + "---超时时间---" + eventType);
		}
	}
}
