package a01.bio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
	
	public static void handler(Socket socket) {
		
		try {
			System.out.println("线程信息id = " + Thread.currentThread().getId() + ";名字=" + Thread.currentThread().getName());
			byte[] bytes = new byte[1024];
			//通过socket获取输入流
			InputStream inputStream = socket.getInputStream();
			//循环
			while(true) {
				
				int read = inputStream.read(bytes);
				
				if(read != -1) {
					System.out.println(new String(bytes, 0, read));//输出客户端发送的数据
				}else {
					break;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			System.out.println("关闭和client的连接");
			
			try {
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	

	public static void main(String[] args) throws Exception {
		
		ExecutorService threadPools = Executors.newCachedThreadPool();
		ServerSocket serverSocket = new ServerSocket(6666);
		System.out.println("服务器启动了");
		
		while(true) {
			
			final Socket socket = serverSocket.accept();
			System.out.println("连接到一个客户端");
			threadPools.execute(new Runnable() {
				
				public void run() {
					//可以和客户端通讯
					handler(socket);
				}
			});
		}
	}
}
