package 算法分析与设计.递归和分治策略;

/**
 * Hanoi塔问题,递归的时候用数学归纳法分析
 * n=1时,A->C
 * n=2时,A->B,A->C,B->C
 * n>3时,
 *  先将上面的n-1个盘由A借助C转移到B
 *  然后最下面的一个大盘由A->C
 *  最后将B上的n-1盘由B借助A转移到C
 * 实际上n>=3的情况是符合n=2的情况
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
