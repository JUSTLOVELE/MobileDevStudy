package 算法第四版.ch01.基础;

/**
 * 计时器对象
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
