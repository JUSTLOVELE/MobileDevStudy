package �㷨���������.̰���㷨;

import java.util.Arrays;

/**
 * �������⣺
 *   ����n����Ʒ��һ������,��Ʒi��������Wi,���ֵΪVi,����������ΪC,Ӧ���ѡ��װ�뱳������Ʒ,ʹ��װ�뱳������Ʒ���ܼ�ֵ���?
 *��ѡ����Ʒiװ�뱳��ʱ,����ѡ����Ʒi��һ����,����һ��Ҫȫ��װ�뱳��
 * ����:
 *  һ�������������:
 *    1.ѡ��ֵ���,��Ȼ����ܾ����ܿ�����ӱ������ܼ�ֵ,����,��Ȼÿһ��ѡ�����˱�����ֵ�ļ�������,����������ȴ�������ĵ�̫��
 *    2.����������,װ�뾡���ܶ����Ʒ,�Ӷ����ӱ������ܼ�ֵ,������Ȼÿһ��ѡ��ʹ�������������ĵ�����,�������ļ�ֵȴû�б�֤Ѹ������
 *    3.ѡ��λ������ֵ������Ʒ,�ڱ�����ֵ�����ͱ���������������֮��Ѱ��ƽ��
 * 
 * �����־��������ӽṹ����,��̰��ѡ����
 * @author Administrator
 *
 */
public class Ex_2_0_1 {
	
	public static int SPACE = 50;
	public static int N = 3;// N == W.length == V.length
	
	public static void main(String[] args) {
		
		int[] W = { 20,30,10 };// ����
		int[] V = { 60,120,50 };// ��ֵ
		knapsack(W, V);
	}
	
	public static void knapsack(int[] W, int[] V){
		
		sort(W, V);
		int space = SPACE;
		int Value = 0;
		
		for(int i=W.length-1; i>=0; i--){
			
			int now = W[i];
			
			if(now < space){
				
				Value += V[i];
				space = space - now;
			}else{
				Value += (space*(V[i]/W[i]));
				break;
			}
		}
		
		System.out.println(Value);
	}
	
	public static void sort(int[] W, int[] V){
		
		int[] value = new int[W.length];
		
		for(int i=0; i<value.length; i++){
			
			value[i] = V[i]/W[i];
		}
		
		sort(W, V, value, 0, W.length-1);
	}
	
	public static void sort(int[] W, int[] V, int[] A, int p, int r){
		if(p<r){
			int q = partition(W,V,A,p,r);
			sort(W,V,A,p,q-1);
			sort(W,V,A,q+1, r);
		}
	}
	
	private static int partition(int[] W, int[] V, int[] A, int p, int r){

		
		int x = A[r];
		int i=p-1;
		
		for(int j=p; j<r; j++){
			
			if(A[j] <= x){
				
				i++;
				exchage(W, V, A, i, j);
			}
		}
		
		exchage(W, V, A, i+1, r);
		
		return i+1;
	}
	
   public static void exchage(int[] W, int[] V, int[] A, int a, int b){
		
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
		
		int d = W[a];
		W[a] = W[b];
		W[b] = d;
		
		int e = V[a];
		V[a] = V[b];
		V[b] = e;
	}
}
