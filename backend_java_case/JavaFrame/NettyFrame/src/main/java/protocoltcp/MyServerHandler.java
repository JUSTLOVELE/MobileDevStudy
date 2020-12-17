package protocoltcp;

import java.nio.charset.Charset;
import java.util.UUID;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol>{
    private int count;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
    	//接收到数据,并处理
    	int len = msg.getLen();
    	byte[] content = msg.getContent();
    	System.out.println("服务器接收到信息如下");
    	System.out.println("长度=" + len);
    	System.out.println("内容=" + new String(content, Charset.forName("utf-8")));
    	System.out.println("服务器接收到消息包数量=" + (++this.count));
    	String respoonseContent = UUID.randomUUID().toString();
    	int responseLen = respoonseContent.getBytes("utf-8").length;
    	MessageProtocol messageProtocol = new MessageProtocol();
    	messageProtocol.setLen(responseLen);
    	messageProtocol.setContent(respoonseContent.getBytes("utf-8"));
    	ctx.writeAndFlush(messageProtocol);
    }
}
