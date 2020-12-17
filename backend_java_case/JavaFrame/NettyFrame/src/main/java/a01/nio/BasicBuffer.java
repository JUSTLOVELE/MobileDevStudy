package a01.nio;

import java.nio.IntBuffer;

public class BasicBuffer {

	public static void main(String[] args) {
		//举例说明Buffer的使用(简单说明)
		//创建一个Buffer
		IntBuffer intBuffer = IntBuffer.allocate(5);
		//向buffer存放数据
		intBuffer.put(10);
		intBuffer.put(11);
		intBuffer.put(12);
		intBuffer.put(13);
		intBuffer.put(14);
		for(int i=0; i<intBuffer.capacity(); i++) {
			intBuffer.put(i*2);
		}
		//如何从buffer读取数据
		intBuffer.flip();//将buffer转换,读写切换
		
		while(intBuffer.hasRemaining()) {
			//每get一次索引就会移动一次
			System.out.println(intBuffer.get());
		}
	}
}
