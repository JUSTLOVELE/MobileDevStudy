package �㷨���������.��ҵ3;

import java.util.Scanner;

/**
 * ���������
 *   ʵ���Ҿ���Ҫ����һ����ȵķ�Ʊ��Sao ������������������ķ�Ʊ���Ͱ�����ͼ
 *�飨A �ࣩ ���ľߣ�B �ࣩ �����ã�C �ࣩ ��Ҫ��ÿ�ŷ�Ʊ���ܶ�ó��� 1000 Ԫ��ÿ�ŷ�Ʊ
 *�ϣ�������Ʒ�ļ�ֵ���ó��� 600 Ԫ��
 *  �������д���� �ڸ�����һ�ѷ�Ʊ���ҳ����Ա����ġ� ������������ȵ��������
 *  
 *  ��������������ɲ���������ÿ�����������ĵ�1�а����������� Q �� N������ Q ��
 *  �����ı�����ȣ�N��<=30���Ƿ�Ʊ����������� N �����룬ÿ�еĸ�ʽΪ��
 *  m Type_1:price_1 Type_2:price_2 ...
 *  ���������� m �����ŷ�Ʊ��������Ʒ�ļ�����Type_i �� price_i �ǵ� i ����Ʒ�������
 *  ��ֵ����Ʒ������һ����дӢ����ĸ��ʾ���� N Ϊ0ʱ��ȫ�������������Ӧ�Ľ����Ҫ��
 *  ��
 *  
 *  �����ʽ:
 *    200.00 3
 *    2 A:23.50 B:100.00
 *    1 C:650.00
 *    3 A:59.99 A:120.00 B:110.00
 *    
 *    
 *  
 * @author Administrator
 *
 */
public class Zdbx {

	private static double Q;
	private static int N;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		/*Q = scanner.nextDouble();
		N = scanner.nextInt();
		double[] A = new double[N];
		
		for(int i=0; i<N; i++){
			int m = scanner.nextInt();
			double d = 0.0;
			for(int j=0; j<m;j++){
				String s = scanner.next();
				String[] array = s.split(":");
				d += Double.valueOf(array[1]);
			}
			A[i] = d;
		}*/
		
		Q = 200.00;
		N = 3;		
		double[] A = new double[N];
		A[0] = 23.5 + 100;
		A[1] = 650.00;
		A[2] = 59.99 + 120.00 + 110.00;
		
		
		double sum = work(A);
		System.out.println(sum);
	}
	
	public static double work(double[] A){
		
		double sum = 0;
		double b = A[0];
		//����ֵ<Q, ������С��Q
		for(int i=1; i<A.length; i++){
			
			double temp = b + A[i];
			
			if(temp > Q){
				
				if(b > Q && A[i] > Q){
					b=0;
				}else if(b > Q && A[i] < Q){
					b = A[i];
				}
			}
			
			if(sum < b){
				sum = b;
			}
		}
		
		
		
		return sum;
	}
}
