package a01.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NIOFileChannel01 {

	public static void main(String[] args) throws Exception {
		
		String str= "hello,yzl";
		FileOutputStream fileOutputStream = new FileOutputStream("d:\\file01.txt");
		//通过fileOutputStream获取对应的FileChannel,真实的类型是FileChannelImpl
		FileChannel fileChannel = fileOutputStream.getChannel();
		//创建一个缓冲区ByteBuffer
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		//将str放入byteBuffer中
		buffer.put(str.getBytes());
		//对byteBuffer进行反转flip;
		buffer.flip();//这样可以把缓冲区的数据写入通道中
		fileChannel.write(buffer);
		fileOutputStream.close();
	}
}
