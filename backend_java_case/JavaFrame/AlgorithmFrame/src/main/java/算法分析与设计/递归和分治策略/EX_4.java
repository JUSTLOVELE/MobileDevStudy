package �㷨���������.�ݹ�ͷ��β���;
/**
 * ���һ���ݹ��㷨����n��Ԫ��{r1,r2,r3,r4...rn}��ȫ����
 * ��R={r1,r2,....,rn}��Ҫ�������е�n��Ԫ��,Ri=R-{ri}
 * ����X��Ԫ�ص�ȫ���м�Ϊperm(X)
 * (ri)perm(X)��ʾ��ȫ����perm(X)��ÿһ������ǰ����ǰ׺�õ�������,R��ȫ���пɹ��ɶ���Ϊ:
 * ��n=1ʱ,perm(R)=(r),����r�Ǽ���R��Ψһ��Ԫ��
 * ��n>1ʱ,perm(R)��(r1)perm(R1),(r2)perm(R2)
 * 
 * @author Administrator
 *
 */
public class EX_4 {

	private int count=0;
	
	public static void main(String[] args) {
		
		char[] array = "ABCD".toCharArray();
		recursion(array, 0);
	}
	
	public static void recursion(char[] array, int k){
		
		if( k == array.length){
			for(int i=0; i<array.length; i++){
				System.out.print(array[i]);
			}
			System.out.println();
		}
		
		for(int i=k; i<array.length; i++){
			char temp = array[k];
			array[k] = array[i];
			array[i] = temp;
			recursion(array, k+1);
			
			temp=array[k];   
			array[k]=array[i]; 
			array[i]=temp;
		}
	}
}
