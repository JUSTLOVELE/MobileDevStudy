package �㷨���İ�.ch01.����;

/**
 * ��ʱ������
 * @author Administrator
 *
 */
public class Stopwatch {
	
	
	private final long start;
	
	public Stopwatch(){
		
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime(){
		
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
	

}
