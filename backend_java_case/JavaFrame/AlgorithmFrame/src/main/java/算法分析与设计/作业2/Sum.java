package �㷨���������.��ҵ2;

import �㷨����.BaseService;

/**
 * ��һ�����У��ҳ�����Ӷκ�
 * �����ö�̬�滮,Ҳ���÷��η�
 * @author Administrator
 *
 */
public class Sum extends BaseService {
	

	public static void main(String[] args) {
		
		int[] a  = {0,6,-1,1,-6,7,-5};
		int[] b = new int[a.length];
		b[0] = a[0];
		int max = b[0];
		int j=1;
		int start = -1;
		int end = -1;
		
		for(int i=1; i<a.length; i++){
			if(b[i-1] > 0){
				b[i] = b[i-1] + a[i];
			}else{
				b[i] = a[i];
				j = i+1;
			}
			
			if(b[i] > max){
				max =b[i];     
	            start =  j;     
	            end  = i+1;    
			}
		}
		
		System.out.println(max + " " + start + " " + end);
	}
	
}
