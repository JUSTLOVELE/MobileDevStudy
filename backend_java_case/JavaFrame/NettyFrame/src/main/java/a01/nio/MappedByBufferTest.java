package a01.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByBufferTest {

	public static void main(String[] args) {
		
		try {
			
			RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\1.txt", "rw");
			//获取对应的通道
			FileChannel channel = randomAccessFile.getChannel();
			
			/**
			 * 参数1: 使用读写模式
			 * 参数2: 0:可以直接修改的起始位置
			 * 参数3: 5:是映射到内存的大小,即将1.txt的多少个字节映射到内存
			 * 实际类型是DirectByteBuffer
			 */
			MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
			mappedByteBuffer.put(0, (byte)'H');//第1个字符变为H
			mappedByteBuffer.put(4, (byte)'9');//第5个字符变为9
			randomAccessFile.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
