package �㷨���İ�.ch02.����;

import �㷨���İ�.ch01.����.Stopwatch;

/**
 * 3.�Ƚ��㷨
 * ����D
 *  ���������������ظ�����������,���������ѡ�����������ʱ����ƽ�������,����֮��Ӧ����һ����С�ĳ���
 * @author yangzuliang
 *
 */
public class SortCompare {
	
	public static double time(String alg, Double[]a){
		
		Stopwatch timer = new Stopwatch();
		if(alg.equals("Insertion")){
			Insertion.sort(a);
		}else if(alg.equals("Selection")){
			Selection.sort(a);
		}else if(alg.equals("Shell")){
			//Shell.sort(a);
		}else if(alg.equals("Merge")){
			//Merge.sort(a);
		}else if(alg.equals("Quick")){
			//Quick.sort(a);
		}else if(alg.equals("Heap")){
			//Heap.sort(a);
		}
		
		return timer.elapsedTime();
	}
	
	/**
	 * ����ΪN�������ظ�T��
	 * @param alg
	 * @param N
	 * @param T
	 * @return
	 */
	public static double timeRandomInput(String alg, int N, int T){
		
		double total = 0.0;
		Double[] a= new Double[N];
		for(int t=0; t<T; t++){
			for(int i=0; i<N; i++){
				a[i] = Stdrandom.uniform();
			}
			total += time(alg, a);
		}
		return total;
	}
	
	public static void main(String[] args) {
		
		String alg1 = "Insertion";
		String alg2 = "Selection";
		int N = 1000;
		int T = 1000;
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		System.out.println(t1);
		System.out.println(t2);
	}

}
