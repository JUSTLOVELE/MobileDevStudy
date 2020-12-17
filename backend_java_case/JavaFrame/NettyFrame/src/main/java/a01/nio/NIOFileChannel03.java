package a01.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NIOFileChannel03 {

	public static void main(String[] args) throws Exception{
		
		FileInputStream fileInputStream = new FileInputStream("D:\\1.txt");
		FileChannel fileChannel01 = fileInputStream.getChannel();
		
		FileOutputStream fileOutputStream = new FileOutputStream("D:\\2.txt");
		FileChannel fileChannel2 = fileOutputStream.getChannel();
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		
		while(true) {
			
			byteBuffer.clear();
			int read = fileChannel01.read(byteBuffer);
			
			if(read == -1) {//表示读完
				break;
			}
			//将buffer中的数据写入到fileChannel2 
			byteBuffer.flip();
			fileChannel2.write(byteBuffer);
		}
		
		fileChannel01.close();
		fileChannel2.close();
	}
}
