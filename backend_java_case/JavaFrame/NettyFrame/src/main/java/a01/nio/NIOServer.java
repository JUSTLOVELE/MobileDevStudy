package a01.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

	public static void main(String[] args) {
		
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			Selector selector = Selector.open();
			//绑定一个端口
			InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6666);
			serverSocketChannel.socket().bind(address);
			//设置为非阻塞
			serverSocketChannel.configureBlocking(false);
			//把serverSocketChannel注册到selector关心事件为OP_ACCEPT
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			//循环等待客户端连接
			while(true) {
				//等待1秒,1秒后如果没有事件发生返回
				if(selector.select(1000) == 0) {
					//没有事件发生
					System.out.println("服务器等待了1秒,无连接");
					continue;
				}
				//如果返回的大于0,就获取到相关的selectionKey集合
				//1.如果返回的>0,表示已经获取到关注的事件
				//2.selector.selectedKeys()返回关注事件的集合
				//3.通过selectedKeys反向获取通道
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				//遍历Set<SelectionKey>,使用迭代遍历
				Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
				
				while(keyIterator.hasNext()) {
					//获取到selectionKey
					SelectionKey key = keyIterator.next();
					//根据key,对应的通道发送的事件做相应处理
					if(key.isAcceptable()) {//如果是OP_ACCEPT,有新的客户端连接
						//该客户端生成一个socketChannel
						SocketChannel socketChannel = serverSocketChannel.accept();
						socketChannel.configureBlocking(false);
						System.out.println("客户端连接成功,生成一个socketChannel:" + socketChannel.hashCode());
						//将socketChannel注册到selector,注册事件是SelectionKey.OP_REA,同时给socketChannel关联一个channel
						socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
					}
					
					if(key.isReadable()) {
						//发送OP_READ
						//通过key反向获取到对应channel
						SocketChannel channel = (SocketChannel) key.channel();
						//获取到该channel关联的buffer
						ByteBuffer buffer = (ByteBuffer) key.attachment();
						channel.read(buffer);
						System.out.println("from client" + new String(buffer.array()));
					}
					//手动从集合中移除当前的selectionKey,防止重复操作
					keyIterator.remove();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
