package a01.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NIOFileChannel02 {

	public static void main(String[] args) throws Exception{

		//创建文件输入流
		File file = new File("d:\\file01.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		//通过fileInputStream获取对应的fileChannel实际的类型是fileChannelImpl
		FileChannel fileChannel = fileInputStream.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
		fileChannel.read(buffer);
		//将bytebuffer字节数据转成string
		System.out.println(new String(buffer.array()));
	}
}
