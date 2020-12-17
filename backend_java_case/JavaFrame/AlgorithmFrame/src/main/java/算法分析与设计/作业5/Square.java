package �㷨���������.��ҵ5;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
/**
 * �����㷨
 * n��Сľ���Ƿ������������,����ľ��������ʹ��
 * ��һ������T,��ʾ�������ݵ�����,5<=T<=100,��������T��,
 * ÿ�б�ʾһ���������,ÿ��������ݵĵ�һ����n(1<=n<=20)
 * ��ʾľ���ĸ���,��������n������,��ʾľ���ĳ���,ľ�����ȵ�
 * ȡֵ��Χ��[1,1000]
 * 
 * ����ÿ���������,���ʹ����Щľ���������һ��������,�����һ��yes,����no
 * 
 * @author Administrator
 *
 */
public class Square {
	
	public static int ok;
	
	public static void main(String[] args) throws Exception {
		
		File file = new File(System.getProperty("user.dir") + "\\src\\�㷨���������\\��ҵ5\\input.txt");
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
		//�ȼ����ܺ�%4�Ƿ�Ϊ0
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
	 * ������:
	 *   ����ܹ��������������� һ������һ��������˳�����а�˳����ӻ���ڱ߳���
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
					//�����������¿�ʼ
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
