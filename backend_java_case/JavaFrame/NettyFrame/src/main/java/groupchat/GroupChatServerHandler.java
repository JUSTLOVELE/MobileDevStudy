package groupchat;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {
	//定义一个channel组
	//GlobalEventExecutor.INSTANCE
	private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	//用id可以找到对应的channel做单聊
	public static Map<String, Channel> channels = new HashMap<String, Channel>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 表示连接建立,一旦连接,第一个被执行
	 * 将当前channel加入到channelGroup
	 */
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		
		Channel channel = ctx.channel();
		//将该客户加入聊天的信息推送给其他在线的客户端
		//这个方法会将channelGroup中所有的channel遍历,并发送消息,我们不需要自己遍历
		channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + "加入聊天\n");
		channelGroup.add(channel);
		//用id可以找到对应的channel做单聊
		channels.put("id100", channel);
	}
	
	/**
	 * 表示channel处于活动状态,表示xx上线
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		System.out.println(ctx.channel().remoteAddress() + "上线了");
	}
	
	/**
	 * 断开连接,将xx客户离开信息推送给当前在线的客户
	 * 触发该方法channelGroup会自动剔除,不用我们remove
	 */
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		
		Channel channel = ctx.channel();
		channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 离开了\n");
		System.out.println("channelGroup size" + channelGroup.size());
	}
	
	/**
	 * channel处于非活动状态，xxx下线
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println(ctx.channel().remoteAddress() + "下线了");
	}
	
	/**
	 * 读取数据
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
	
		System.out.println(msg);
		Channel channel = ctx.channel();
		//此时我们遍历channelGroup,根据不同的情况,回送不同的信息
		channelGroup.forEach(ch -> {
			if(channel != ch) {
				//不是当前的channel,转发消息
				ch.writeAndFlush("[客户]" + channel.remoteAddress() + " 发送了消息" + msg + "\n");
			}else {
				ch.writeAndFlush("[自己]发送了消息给自己,这里回显了一下:" + msg + "\n" );
			}
		});
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		//异常的话关闭即可
		ctx.close();
	}
}
