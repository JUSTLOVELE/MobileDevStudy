package a01.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class GroupChatServer {

	private Selector selector;
	
	private ServerSocketChannel listenChannel;
	
	private static final int PORT = 6667;
	
	public GroupChatServer() {
		
		try {
			selector = Selector.open();
			listenChannel = ServerSocketChannel.open();
			listenChannel.socket().bind(new InetSocketAddress(PORT));
			listenChannel.configureBlocking(false);
			listenChannel.register(selector, SelectionKey.OP_ACCEPT);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			GroupChatServer groupChatServer = new GroupChatServer();
			groupChatServer.listen();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	//转发消息给其他客户(通道)
	private void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {
		
		System.out.println("服务器转发消息...");
		//遍历所有注册到selector上的socketchannel并删除自己
		for(SelectionKey key: selector.keys()) {
			//通过key取出对应的socketChannel
			SelectableChannel targetChannel = (SelectableChannel) key.channel();
			//排除自己
			if(targetChannel instanceof SocketChannel && targetChannel != self) {
				//转型
				((SocketChannel)targetChannel).write(ByteBuffer.wrap(msg.getBytes()));
			}
		}
	}
	
	private void readData(SelectionKey key) {
		//定义一个socketchannel
		SocketChannel channel = null;
		
		try {
			//取到关联的channel
			channel = (SocketChannel) key.channel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int count = channel.read(buffer);
			//根据count的值做处理
			if(count > 0) {
				//把缓存区的数据转为字符串
				String msg = new String(buffer.array());
				//输出该消息
				System.out.println("from 客户端:" + msg);
				//向其他的客户端转发消息(去掉自己),专门写一个方法来处理
				sendInfoToOtherClients(msg, channel);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			try {
				
				System.out.println(channel.getRemoteAddress() + " 离线");
				key.cancel();
				channel.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void listen() {
		
		try {
			
			while(true) {
				
				int count = selector.select();
				
				if(count > 0) {//有事件处理
					
					Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
					
					while(iterator.hasNext()) {
						
						SelectionKey key = iterator.next();
						
						if(key.isAcceptable()) {
							
							SocketChannel sc = listenChannel.accept();
							sc.configureBlocking(false);
							//将该sc注册到selector
							sc.register(selector, SelectionKey.OP_READ);
							
							//提示
							System.out.println(sc.getRemoteAddress() + "上线");
						}
						
						if(key.isReadable()) {
							readData(key);
						}
						//当前的key删除,防止重复处理
						iterator.remove();
						
					}
					
				}else {
					System.out.println("等待中");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
