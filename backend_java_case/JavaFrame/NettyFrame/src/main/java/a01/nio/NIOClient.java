package a01.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {

	public static void main(String[] args) {
		try {
			//得到一个网络通道
			SocketChannel socketChannel = SocketChannel.open();
			//设置非阻塞模式
			socketChannel.configureBlocking(false);
			//提供服务器端的ip和端口
			InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6666);
			//连接服务器
			if(!socketChannel.connect(address)) {
				
				while(!socketChannel.finishConnect()) {
					//在这里做别的工作
					System.out.println("因为连接需要时间,客户端不会阻塞,可以做其他工作");
				}
			}
			//连接成功发送数据
			String str= "hello world";
			ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
			//发送数据,将buffer数据写入channel
			socketChannel.write(byteBuffer);
			System.in.read();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
