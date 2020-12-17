package a01.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NIOFileChannel04 {

	public static void main(String[] args) {
		
		try {
			//创建相关流
			FileInputStream fileInputStream = new FileInputStream("D:\\test.jpg");
			FileOutputStream fileOutputStream = new FileOutputStream("D:\\test2.jpg");
			//获取各个流程对应的filechannel
			FileChannel sourceCh = fileInputStream.getChannel();
			FileChannel destCh = fileOutputStream.getChannel();
			destCh.transferFrom(sourceCh, 0, sourceCh.size());
			//关闭相关通道和流
			sourceCh.close();
			destCh.close();
			fileInputStream.close();
			fileOutputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
