package 算法分析与设计.作业4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import org.junit.Test;

/**
 * 活动安排问题
 *   小张子作为学生会的一名， 要将足够多的会场安排给一批活动，同事又希望所使用会场
 * 尽可能的少,为他设计一个贪心算法
 * 
 * 任务:
 *   对于给定的 k 个待安排的会场，计算所使用的最少会场数能满足这些活动的安排
 *   
 * 输入:
 *   第一行为一个正整数 k (1<=k<=10000),表示待安排的活动的个数, 接下来有 k行,
 *   每行均有两个正整数,表示第 k个活动的开始时间和结束时间,时间计算从 0开始,每分钟多 1
 *   
 * 
 * @author yangzuliang
 *
 */
public class Activity {

	private int numbers;
	private int[][] taskMatrix;
	
	@Test
	public void test(){
		
		init();
		work();
	}
	
	public void work(){
		
		int [] temp = new int[numbers];
		
		
	}
	
	public void init(){
		
		try {
			
			String path = System.getProperty("user.dir") + "/src/main/java/算法分析与设计/作业4/activity.txt";
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			Scanner scanner = new Scanner(new BufferedInputStream(fis));
			numbers = scanner.nextInt();
			taskMatrix = new int[numbers][2];
			
			for(int i=0; i<numbers; i++){
				for(int j=0; j<=1; j++){
					taskMatrix[i][j] = scanner.nextInt();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
