package �㷨���İ�.ch02.��ϰ;

import �㷨���İ�.ch01.����.Stopwatch;
import �㷨���İ�.ch02.����.Insertion;
import �㷨���İ�.ch02.����.Selection;

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
	 * ��ϰ2.18
	 * ����Ԫ��ֻ����������ֵ,ʹ�ò�������������һ��������������ʱ�������ԵĻ���ƽ������,���ǽ�������֮��
	 */
	public static void execute2_1_8(){
		
	}
	
	/**
	 * ��ϰ2.1.7
	 * ������������ѡ������Ͳ�������˭����
	 */
	public static void execute2_1_7(){
		
		Integer[] selectArray = new Integer[10000];
		for(int i=selectArray.length-1; i>=0; i--){
			selectArray[i] = i;
		}
		Stopwatch selectTimer = new Stopwatch();
		Selection.sort(selectArray);
		System.out.println("ѡ������:" + selectTimer.elapsedTime());
		Stopwatch insertTimer = new Stopwatch();
		Insertion.sort(selectArray);
		System.out.println("��������:" + insertTimer.elapsedTime());
	}

	/**
	 * ��ϰ2.1.6
	 * �����е���������ͬʱ,ѡ������Ͳ�������˭����:
	 * ����ѡ������ÿ�ζ���Ƚ�ÿ��Ԫ�صĴ�С
	 * ���ڲ���������Ϊÿ��ֵ����һ����������ִ�в�����ѭ��
	 */
	public static void execute2_1_6(){
		
		Integer[] selectArray = new Integer[30000];
		for(int i=0; i<selectArray.length; i++){
			selectArray[i] = 100;
		}
		Stopwatch selectTimer = new Stopwatch();
		Selection.sort(selectArray);
		System.out.println("ѡ������:" + selectTimer.elapsedTime());
		Stopwatch insertTimer = new Stopwatch();
		Insertion.sort(selectArray);
		System.out.println("��������:" + insertTimer.elapsedTime());
	}
}
