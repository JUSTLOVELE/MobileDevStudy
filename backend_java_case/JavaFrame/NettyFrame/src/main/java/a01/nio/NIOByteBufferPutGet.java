package a01.nio;

import java.nio.ByteBuffer;

public class NIOByteBufferPutGet {

	public static void main(String[] args) {
		
		try {
			//创建一个buffer
			ByteBuffer buffer = ByteBuffer.allocate(64);
			//类型化方式放入数据
			buffer.putInt(100);
			buffer.putLong(9);
			buffer.putChar('杨');
			buffer.putShort((short) 4);
			//取出
			buffer.flip();
			System.out.println();
			System.out.println(buffer.getInt());
			System.out.println(buffer.getLong());
			System.out.println(buffer.getChar());
			System.out.println(buffer.getShort());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
