package �㷨���������.�ݹ�ͷ��β���;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import �㷨����.BaseService;

/**
 * ��ӽ�������� ���ⳡ������Ӧ���У���������㡢Բ�ȼ򵥵ļ��ζ��������ʵ�����е�ʵ�塣
 * ���漰��Щ���ζ���������У�����Ҫ�˽����������������ζ������Ϣ�����磬�ڿ��н�ͨ���������У�
 * �����ɻ���Ϊ�ռ����ƶ���һ����������������������ײΣ�յ�2�ܷɻ�����������ռ�����ӽ���һ�Ե㡣 ���������Ǽ��㼸��ѧ���о��Ļ�������֮һ��
 * ��������������ƽ����n���㣬�����е�һ�Ե㣬ʹ����n��������е���У��õ�Եľ�����С��
 * �ϸ��˵����ӽ���Կ��ܶ���1�ԡ�Ϊ�˼����������ֻ���������е�һ��
 * 
 * 
 * @author Administrator
 * 
 */
public class Ex_9_Cpair extends BaseService {

	static class Point {
		public Point() {
		}

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		double x;
		double y;
	}

	public static void main(String[] args) {

		/*
		 * int[] A = reduceArray(10, 100); Arrays.sort(A);//Ҳ�����ñ������ print(A);
		 * work_1(A, 0, A.length-1);
		 */
		// ��ά
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Point[] ps = new Point[n];
		for (int i = 0; i < n; i++) {
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			ps[i] = new Point(x, y);
		}

		Arrays.sort(ps, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x < o2.x)
					return -1;
				if (o1.x > o2.x)
					return 1;
				if (o1.y < o2.y)
					return -1;
				if (o1.y > o2.y)
					return 1;
				return 0;
			}
		});

		double minDis = minDistance(ps, 0, n - 1);
		System.out.println(minDis);
	}

	/**
	 * ���֮�����С����
	 * 
	 * @param ps
	 * @param l
	 * @param r
	 * @return
	 */
	public static double minDistance(Point[] ps, int l, int r) {

		/**
		 * ͬһ����,�����ڵ��,���벻��ȡ0,�������ֵ
		 */
		if (l == r) {
			return Double.MAX_VALUE;
		}

		if (l + 1 == r) {
			return distance(ps[l], ps[r]);
		}

		int center = l + (r - l) / 2;
		double dis1 = minDistance(ps, l, center);
		double dis2 = minDistance(ps, center + 1, r);
		double minDis = min(dis1, dis2);
		ArrayList<Point> nearPoints = new ArrayList<>();

		for (Point p : ps) {
			if (abs(ps[center].x - p.x) <= minDis) {
				nearPoints.add(p);
			}
		}

		// ����Y����������
		Collections.sort(nearPoints, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.y < o2.y)
					return -1;
				if (o1.y > o2.y)
					return 1;
				if (o1.x < o2.x)
					return -1;
				if (o1.x > o2.x)
					return 1;
				return 0;
			}
		});
		
		for (int i = 0; i < nearPoints.size(); i++) {
			for (int j = i + 1; j < nearPoints.size(); j++) {
				if (nearPoints.get(j).y - nearPoints.get(i).y > minDis) {
					break;// Ԫ��y+1��Ԫ��i��Զ,û��Ҫ�����Ƚ�
				}
				double d = distance(nearPoints.get(j), nearPoints.get(i));
				if (d < minDis) {
					minDis = d;
				}
			}
		}
		
		return minDis;
	}

	public static double distance(Point p1, Point p2) {
		if (p1 == p2)
			return 0;
		return sqrt(pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2));
	}

	/**
	 * һά�ⷨ
	 */
	public static void work_1(int[] A, int start, int end) {

		int length = (start + end) / 2;
		int left = getMin(A, 0, length, Integer.MAX_VALUE);
		int right = getMin(A, length + 1, end, Integer.MAX_VALUE);
		int mid = A[length + 1] - A[length];

		System.out.println("left = " + left);
		System.out.println("right = " + right);
		System.out.println("mid = " + mid);
	}

	public static int getMin(int[] A, int start, int end, int min) {

		for (int i = start + 1; i <= end; i++) {

			int temp = A[i] - A[i - 1];

			if (temp < min) {
				min = temp;
			}
		}

		return min;
	}
}
