package �㷨���������.̰���㷨;

import java.util.Date;

/**
 * ���������
 *   ����n����ļ���E={1,2,...,n},����ÿ��
 *���Ҫ��ʹ��ͬһ��Դ,���ݽ��᳡��,����ͬһʱ����
 *ֻ��һ�����ʹ����һ��Դ,ÿ���i����һ��Ҫ��ʹ�ø���Դ����ʼʱ��
 *si��һ������ʱ��fi,��si<fi,���ѡ���˻i,�����ڰ뿪ʱ������
 *[si, fi)��ռ����Դ,������[si, fi)������[sj, fj)���ཻ,���Ϊ
 *�i��j�����ݵ�,Ҳ����˵��si>=fj��sj>=fiʱ�i��j����
 * @author Administrator
 *
 */
public class Ex_1_Action {
	
	public static void main(String[] args) {
		
		int[] s = {1,3,0,5,3,5,6,8,8,2,12};
		//������ʱ��Ǽ�������
		int[] f = {4,5,6,7,8,9,10,11,12,13,14};
		boolean[] A = {false,false,false,false,false,false,false,false,false,false,false};
		GreedySelector(10, s, f, A);
	}
	
	public static void GreedySelector(int n, int[] s, int[] f, boolean[] A){
		
		A[1] = true;
		int j = 1;
		for(int i=2; i<=n; i++){
			if(s[i] >= f[j]){
				A[i] = true;
				j=i;
			}
		}
		
		for(int i=0; i<A.length; i++){
			
			if(A[i]){
				System.out.println("��ʼʱ��:" + s[i] + ";����ʱ��:" + f[i]);
			}
		}
		
	}
}
