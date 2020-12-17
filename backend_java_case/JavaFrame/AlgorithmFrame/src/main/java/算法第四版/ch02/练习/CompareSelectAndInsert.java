package 算法第四版.ch02.练习;

import 算法第四版.ch01.基础.Stopwatch;
import 算法第四版.ch02.排序.Insertion;
import 算法第四版.ch02.排序.Selection;

/**
 * @author Administrator
 *
 */
public class CompareSelectAndInsert {
	
	public static void main(String[] args) {
		//execute2_1_6();
		execute2_1_7();
	}
	
	/**
	 * 练习2.18
	 * 假设元素只可能有三种值,使用插入排序处理这样一个随机数组的运行时间是线性的还是平方级的,或是介于两者之间
	 */
	public static void execute2_1_8(){
		
	}
	
	/**
	 * 练习2.1.7
	 * 对于逆序数组选择排序和插入排序谁更快
	 */
	public static void execute2_1_7(){
		
		Integer[] selectArray = new Integer[10000];
		for(int i=selectArray.length-1; i>=0; i--){
			selectArray[i] = i;
		}
		Stopwatch selectTimer = new Stopwatch();
		Selection.sort(selectArray);
		System.out.println("选择排序:" + selectTimer.elapsedTime());
		Stopwatch insertTimer = new Stopwatch();
		Insertion.sort(selectArray);
		System.out.println("插入排序:" + insertTimer.elapsedTime());
	}

	/**
	 * 练习2.1.6
	 * 在所有的主键都相同时,选择排序和插入排序谁更快:
	 * 对于选择排序每次都会比较每个元素的大小
	 * 对于插入排序因为每个值都是一样的所以他执行不到内循环
	 */
	public static void execute2_1_6(){
		
		Integer[] selectArray = new Integer[30000];
		for(int i=0; i<selectArray.length; i++){
			selectArray[i] = 100;
		}
		Stopwatch selectTimer = new Stopwatch();
		Selection.sort(selectArray);
		System.out.println("选择排序:" + selectTimer.elapsedTime());
		Stopwatch insertTimer = new Stopwatch();
		Insertion.sort(selectArray);
		System.out.println("插入排序:" + insertTimer.elapsedTime());
	}
}
