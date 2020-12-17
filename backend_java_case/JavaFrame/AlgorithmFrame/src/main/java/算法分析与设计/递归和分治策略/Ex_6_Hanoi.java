package �㷨���������.�ݹ�ͷ��β���;

/**
 * Hanoi������,�ݹ��ʱ������ѧ���ɷ�����
 * n=1ʱ,A->C
 * n=2ʱ,A->B,A->C,B->C
 * n>3ʱ,
 *  �Ƚ������n-1������A����Cת�Ƶ�B
 *  Ȼ���������һ��������A->C
 *  ���B�ϵ�n-1����B����Aת�Ƶ�C
 * ʵ����n>=3������Ƿ���n=2�����
 * @author Administrator
 *
 */
public class Ex_6_Hanoi {

	public static void main(String[] args) {
		
		hanoi(2, 'A', 'B', 'C');
	}
	
	public static void hanoi(int n, char a, char b, char c){
		
		if(n == 1){
			System.out.println(a + "->" + c);
		}else{
			hanoi(n-1, a, c, b);
			hanoi(1, a, b, c);
			hanoi(n-1, b, a, c);
		}
	}
}
