package �㷨���������.��ҵ4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import org.junit.Test;

/**
 * ���������
 *   С������Ϊѧ�����һ���� Ҫ���㹻��Ļ᳡���Ÿ�һ�����ͬ����ϣ����ʹ�û᳡
 * �����ܵ���,Ϊ�����һ��̰���㷨
 * 
 * ����:
 *   ���ڸ����� k �������ŵĻ᳡��������ʹ�õ����ٻ᳡����������Щ��İ���
 *   
 * ����:
 *   ��һ��Ϊһ�������� k (1<=k<=10000),��ʾ�����ŵĻ�ĸ���, �������� k��,
 *   ÿ�о�������������,��ʾ�� k����Ŀ�ʼʱ��ͽ���ʱ��,ʱ������ 0��ʼ,ÿ���Ӷ� 1
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
			
			String path = System.getProperty("user.dir") + "/src/main/java/�㷨���������/��ҵ4/activity.txt";
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
