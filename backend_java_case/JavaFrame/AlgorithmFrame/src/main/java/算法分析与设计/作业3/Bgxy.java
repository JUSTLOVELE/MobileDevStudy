package �㷨���������.��ҵ3;


/**
 * ���ѧҽ
 *   abingoo �������ǳ�Ϊһλ����������ҽ����Ϊ�˴��Ը����������ݸ�������������
 * ҽ��Ϊʦ��ҽ��Ϊ���ж��������ʣ���������һ�����⡣ҽ����������һ���������ǲ�ҩ��
 * ɽ�������˵�������ӣ����ɽ������һЩ��ͬ�Ĳ�ҩ����ÿһ�궼��ҪһЩʱ�䣬ÿһ��
 * Ҳ��������ļ�ֵ���һ����һ��ʱ�䣬�����ʱ�������Բɵ�һЩ��ҩ���������һ
 * �������ĺ��ӣ���Ӧ�ÿ����òɵ��Ĳ�ҩ���ܼ�ֵ���
 * 
 * �������д�����ڸ��������ʱ����ɲ�ҩ���òɵ��Ĳ�ҩ���ܼ�ֵ���
 * 
 * ����ĵ�һ������������ T��1 <= T <= 1000���� M��1 <= M <= 100�� ����һ���ո����
 * T �����ܹ��ܹ�������ҩ��ʱ�䣬M ����ɽ����Ĳ�ҩ����Ŀ���������� M ��ÿ�а�����
 * ���� 1 �� 100 ֮�䣨���� 1 �� 100�����������ֱ��ʾ��ժĳ���ҩ��ʱ��������ҩ�ļ�ֵ��
 * 
 * @author Administrator
 *
 */
public class Bgxy {

	private static int TIME = 100;
	private static int NUM = 5;
	private static int[][] memo;
	private static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		int[] T = {77,22,29,50,99};
		int[] M = {92,22,87,46,90};
		memo = new int[NUM][NUM];
		
		for(int i=0; i<NUM; i++){
			for(int j=0; j<NUM; j++){
				memo[i][j] = -1;
			}
		}
		work(T, M, 0, 4);
		System.out.println(MAX);
	}
	
	public static void work(int[] T, int M[], int left, int right){
		
		for(int i=left; i<right; i++){
			
			if(memo[left][i] == -1){
				work(T, M, left, i);
				memo[left][i] = -2;
				int timeSum = 0;
				int numSum = 0;
				for(int k=left; k<=i; k++){
					timeSum += T[k];
					numSum += M[k];
				}
				if(timeSum <= TIME){
					memo[left][i] = numSum;
					if(numSum > MAX){
						MAX = numSum;
					}
				}else{
					memo[left][i] = -2;
				}
				System.out.println(left+","+i+" " + numSum + " " + timeSum);
			}
			
			if(memo[i+1][right] == -1){
				work(T, M, i+1, right); 
				memo[i+1][right] = -2;
				int timeSum = 0;
				int numSum = 0;
				for(int k= i+1; k<=right; k++){
					timeSum += T[k];
					numSum += M[k];
				}
				if(timeSum <= TIME){
					memo[i+1][right] = numSum;
					if(numSum > MAX){
						MAX = numSum;
					}
				}else{
					memo[i+1][right] = -2;
				}
				System.out.println((i+1) + "," + right + " " + numSum + " " + timeSum);				
			}
		}
	}
}
