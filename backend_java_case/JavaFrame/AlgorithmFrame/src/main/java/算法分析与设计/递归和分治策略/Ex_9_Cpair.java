package 算法分析与设计.递归和分治策略;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import 算法导论.BaseService;

/**
 * 最接近点对问题 问题场景：在应用中，常用诸如点、圆等简单的几何对象代表现实世界中的实体。
 * 在涉及这些几何对象的问题中，常需要了解其邻域中其他几何对象的信息。例如，在空中交通控制问题中，
 * 若将飞机作为空间中移动的一个点来看待，则具有最大碰撞危险的2架飞机，就是这个空间中最接近的一对点。 这类问题是计算几何学中研究的基本问题之一。
 * 问题描述：给定平面上n个点，找其中的一对点，使得在n个点的所有点对中，该点对的距离最小。
 * 严格地说，最接近点对可能多于1对。为了简单起见，这里只限于找其中的一对
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
		 * int[] A = reduceArray(10, 100); Arrays.sort(A);//也可以用别的排序 print(A);
		 * work_1(A, 0, A.length-1);
		 */
		// 二维
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
	 * 点对之间的最小距离
	 * 
	 * @param ps
	 * @param l
	 * @param r
	 * @return
	 */
	public static double minDistance(Point[] ps, int l, int r) {

		/**
		 * 同一个点,不存在点对,距离不能取0,返回最大值
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

		// 按照Y轴升序排序
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
					break;// 元素y+1离元素i更远,没必要继续比较
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
	 * 一维解法
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
