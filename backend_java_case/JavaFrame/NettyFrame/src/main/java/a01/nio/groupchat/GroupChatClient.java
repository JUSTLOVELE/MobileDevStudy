package a01.nio.groupchat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class GroupChatClient {

	private final String HOST = "127.0.0.1";
	
	private final int PORT = 6667;
	
	private Selector selector;
	
	private SocketChannel socketChannel;
	
	private String username;
	
	public GroupChatClient() {
		
		try {
			selector = Selector.open();
			socketChannel = socketChannel.open(new InetSocketAddress(HOST, PORT));
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_READ);
			String username = socketChannel.getLocalAddress().toString();
			System.out.println(username + " is ok...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//向服务器发送消息
	public void sendInfo(String info) {
		
		try {
			info = username + "说: " + info;
			socketChannel.write(ByteBuffer.wrap(info.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//读取从服务器端回复的消息
	public void readInfo() {
		
		try {
			
			int readChannels = selector.select();
			
			if(readChannels > 0) {
				//有可用的通道
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				
				while(iterator.hasNext()) {
					
					SelectionKey key = iterator.next();
					
					if(key.isReadable()) {
						//得到相关的通道
						SocketChannel sc = (SocketChannel) key.channel();
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						//得到一个buffer
						sc.read(buffer);
						String msg = new String(buffer.array());
						System.out.println(msg.trim());
					}
				}
				//删除当前的selectionKey,防止重复操作
				iterator.remove();
			}else {
				//System.out.println("没有可用的通道");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
 	public static void main(String[] args) {
 		
 		try {
			
 			GroupChatClient chatClient = new GroupChatClient();
 			//启动一个线程,每隔3秒读取服务器的发送数据
 			Thread thread = new Thread() {
 				
 				@Override
 				public void run() {
 					
 					while(true) {
 						
 						chatClient.readInfo();
 						try {
							Thread.currentThread().sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
 					}
 				}
 			};
 			
 			thread.start();
 			//客户端发送数据给服务器端
 			Scanner scanner = new Scanner(System.in);
 			
 			while(scanner.hasNextLine()) {
 				
 				String s = scanner.nextLine();
 				chatClient.sendInfo(s);
 			}
 			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
