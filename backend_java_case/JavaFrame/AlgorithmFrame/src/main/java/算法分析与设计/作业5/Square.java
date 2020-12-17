package 算法分析与设计.作业5;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 回溯算法
 * n个小木棒是否能组成正方形,所有木棒都必须使用
 * 第一行输入T,表示测试数据的组数,5<=T<=100,接下来有T行,
 * 每行表示一组测试数据,每组测试数据的第一整数n(1<=n<=20)
 * 表示木棒的根数,接下来有n个整数,表示木棒的长度,木棒长度的
 * 取值范围是[1,1000]
 * 
 * 对于每组测试数据,如果使用这些木棒可以组成一个正方形,则输出一行yes,否则no
 * 
 * @author Administrator
 *
 */
public class Square {
	
	public static int ok;
	
	public static void main(String[] args) throws Exception {
		
		File file = new File(System.getProperty("user.dir") + "\\src\\算法分析与设计\\作业5\\input.txt");
		Scanner scanner = new Scanner(file);
		int line = Integer.valueOf(scanner.nextLine());
		
		for(int i=0; i<line; i++){
			
			String s = scanner.nextLine();
			String[] array = s.split(" ");
			int length = Integer.valueOf(array[0]);
			int[] sq = new int[length];
			
			for(int j=0; j<length; j++){
				sq[j] = Integer.valueOf(array[j+1]);
 			}
			ok= 0;
			work(sq);
		}
	}
	
	public static void work(int[] sq){
		//先计算总和%4是否为0
		int count = 0;
		for(int i=0; i<sq.length; i++){
			count += sq[i];
		}
		int side = count/4;
		if(count%4 != 0){
			System.out.println("no");
		}else{
			backTrace(sq, side, 0);
			
			if(ok == 1){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
	}
	
	/**
	 * 排列树:
	 *   如果能够排序列正方形则 一定存在一个序列是顺序排列按顺序相加会等于边长度
	 * @param sq
	 * @param side
	 * @param t
	 */
	public static void backTrace(int[] sq, int side, int t){
		
		if(t >= sq.length){
			
			int temp = 0;
			int count = 0;
			
			for(int i=0; i<sq.length; i++){
				
				temp += sq[0];
				
				if(side == temp){
					//计数归零重新开始
					count = count + 1;
					temp = 0;
				}
			}
			
			if(count == 4){
				
				//System.out.println(Arrays.toString(sq));
				ok = 1;
				return;
			}
		}else{
			for(int i=t; i<sq.length; i++){
				swap(sq, i, t);
				backTrace(sq, side, t+1);
				swap(sq, i, t);
			}
		}
	}
	
	public static void swap(int[] x, int i, int j){
		int a = x[i];
	    x[i] = x[j];
	    x[j] = a;
	}
}
