package 算法分析与设计.递归和分治策略;
/**
 * 设计一个递归算法生成n个元素{r1,r2,r3,r4...rn}的全排列
 * 设R={r1,r2,....,rn}是要进行排列的n个元素,Ri=R-{ri}
 * 集合X中元素的全排列记为perm(X)
 * (ri)perm(X)表示在全排列perm(X)的每一个排列前加上前缀得到的排列,R的全排列可归纳定义为:
 * 当n=1时,perm(R)=(r),其中r是集合R中唯一的元素
 * 当n>1时,perm(R)由(r1)perm(R1),(r2)perm(R2)
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
