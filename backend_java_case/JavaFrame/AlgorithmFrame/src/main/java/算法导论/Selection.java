package 算法导论;

/**
 * 它的工作原理是每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完
 * @author Administrator
 *SELECTION-SORT(A)
       n =A:length
       for j = 1 to n  1
         smallest = j
         for i = j + 1 to n
            if A[i]<A[smallest]
                smallest = i
         exchange A[j] with A[smallest]
     时间复杂度： O(N^2), 比较的次数：n(n-1)/2
     最好的情况下已有序,交换0次,最坏情况交换n-1次(实际交换数值的位置,不计算临时变量)
     逆序交换n/2次,交换次数比冒泡排序少,由于交换所需cpu时间比比较所需的Cpu时间多,n值较小,选择排序比冒泡排序块
  稳定性：
  选择排序是给每个位置选择当前元素最小的,比如给第一个位置选择最小的,在剩余元素里面给第二个元素选择第二小的,依次类推,直到第n-1个元素,
  第n个元素不用选择了,因为只剩下它一个最大的元素了;那么,在一趟选择,如果一个元素比当前元素小,而该小的元素又出现在一个和当前元素相等的元素后面,
  那么交换后稳定性就被破坏了;比较拗口,举个例子,序列5 8 5 2 9,我们知道第一遍选择第1个元素5会和2交换,那么原序列中两个5的相对前后顺序就被破坏了,所以选择排序是一个不稳定的排序算法
 */
public class Selection {
	
	public static Integer[] select(Integer[] ints){
		
		int length = ints.length;
		for(int j=0; j<length-1; j++){
			int smallest = j;
			for(int i=j+1; i<length; i++){
				if(ints[i] < ints[smallest]){
					smallest = i;
				}
			}
			int temp = ints[smallest];
			ints[smallest] = ints[j];
			ints[j] = temp;
		}
		
		
		return ints;
		
		
	}
	
	public static void main(String[] args) {
		
		Integer[] ints = {2,1,5,9,4,6,8,3};
		ints = select(ints);
		for(int i : ints){
			System.out.print(i);
		}
	}

}










