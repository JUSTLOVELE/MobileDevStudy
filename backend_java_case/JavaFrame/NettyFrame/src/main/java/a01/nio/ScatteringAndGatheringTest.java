package a01.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scattering: 将数据写入到buffer时,可以采用buffer数组,依次写入[分散]
 * Gathering: 从buffer读取数据时,可以采用buffer数组,依次读
 * @author Administrator
 *
 */
public class ScatteringAndGatheringTest {

	public static void main(String[] args) {
		
		try {
			//使用ServerSocketChannel和socketchannel网络
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
			//绑定端口到socket,并启动
			serverSocketChannel.socket().bind(inetSocketAddress);
			ByteBuffer[] byteBuffers = new ByteBuffer[2];
			byteBuffers[0] = ByteBuffer.allocate(5);
			byteBuffers[1] = ByteBuffer.allocate(3);
			//等待客户端连接
			SocketChannel socketChannel = serverSocketChannel.accept();
			int messageLength = 0;
			
			while(true) {
				
				int byteRead = 0;
				
				while(byteRead < messageLength) {
					
					long l = socketChannel.read(byteBuffers);
					byteRead += l;//累计读取的字节数
					System.out.println("byteRead=" + byteRead);
					//使用流打印
					Arrays.asList(byteBuffers).stream().map(
							buffer -> "postion=" + buffer.position() + ",limit=" +
					buffer.limit()).forEach(System.out::println);
				}
				
				//将所有的buffer进行flip
				Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());
				int byteWrite = 0;
				
				while(byteWrite < messageLength) {
					
					long l = socketChannel.write(byteBuffers);
					byteWrite += 1;
				}
				
				Arrays.asList(byteBuffers).forEach(buffer -> buffer.clear());
				System.out.println("byteRead=" + byteRead + ";byteWrite=" + byteWrite + ";messageLength=" + messageLength);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
