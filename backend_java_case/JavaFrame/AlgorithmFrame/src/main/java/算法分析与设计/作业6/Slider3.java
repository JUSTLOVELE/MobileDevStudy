package 算法分析与设计.作业6;

import java.util.ArrayList;
import java.util.List;

import 算法第四版.ch01.基础.Queue;

/**
 * 滑块游戏 解题思路: 要找到行数一致或者列数一致
 * 
 * @author Administrator
 * 
 */
public class Slider3 {

	static int n;
	static int k;
	static int[] slider = new int[2];//滑块坐标
	static int[] pit = new int[2];//坑的坐标
	static int FIND = 0;//当FIND = 1时表示已经找到了
	static Queue<Point> q = new Queue<Point>();

	public static void main(String[] args) {

		
		 /*n = 4; 
		 k = 2; 
		 slider[0] = 1;
		 slider[1] = 0; 
		 pit[0] = 3;
		 pit[1] = 1;
		 int[][] walls = new int[k][n];
		 walls[0][0] = 3;
		 walls[0][1] = 0;
		 walls[0][2] = 3;
		 walls[0][3] = 1;
		 
		 walls[1][0] = 2;
		 walls[1][1] = 1;
		 walls[1][2] = 3;
		 walls[1][3] = 1;*/
		
		 n = 4; 
		 k = 1; 
		 slider[0] = 1;
		 slider[1] = 0; 
		 pit[0] = 1;
		 pit[1] = 3;
		 int[][] walls = new int[k][n];
		 walls[0][0] = 1;
		 walls[0][1] = 1;
		 walls[0][2] = 1;
		 walls[0][3] = 2;
		

		/*Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		slider[0] = scanner.nextInt();
		slider[1] = scanner.nextInt();
		pit[0] = scanner.nextInt();
		pit[1] = scanner.nextInt();
		int[][] walls = new int[k][3];

		for (int i = 0; i < k; k++) {
			walls[i][0] = scanner.nextInt();
			walls[i][1] = scanner.nextInt();
			walls[i][2] = scanner.nextInt();
			walls[i][3] = scanner.nextInt();
		}*/

		// int[][] model = new int[n][n];
		// 如果坑和滑块一个位置,则直接输出0结束
		if (slider[0] == pit[0] && slider[1] == pit[1]) {
			System.out.println(0);
			return;
		}

		int[][] bak = new int[n][n];// 备忘数组
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bak[i][j] = 0;
			}
		}
		// work(walls);
		q.enqueue(new Point(slider[0], slider[1]));
		int c = 0;
		bak[slider[0]][slider[1]] = -2;
		outer:
		while(!q.isEmpty()){
			c++;
			List<Point> zbs = new ArrayList<Point>();
			int length = q.size();
			for(int i=0; i<length; i++){
				Point point = q.dequeue();
				System.out.println(point.toString());
				
				Point zbUp = up(walls, bak, point.getX(), point.getY(), c);
				if(zbUp != null){
					zbs.add(zbUp);
					System.out.println("上边:" + zbUp.toString());
				}
				if(FIND == 1){
					break outer;
				}
				
				Point zuRight = right(walls, bak, point.getX(), point.getY(), c);
				if(zuRight != null){
					zbs.add(zuRight);
					System.out.println("右边:" + zuRight.toString());
				}
				
				if(FIND == 1){
					break outer;
				}
				
				Point zbDown = down(walls, bak, point.getX(), point.getY(), c);
				if(zbDown != null){
					zbs.add(zbDown);
					System.out.println("下边:" + zbDown.toString());
				}
				
				if(FIND == 1){
					break outer;
				}
				
				Point zbLeft = left(walls, bak, point.getX(), point.getY(), c);
				if(zbLeft != null){
					zbs.add(zbLeft);
					System.out.println("左边:" + zbLeft.toString());
				}
				
				if(FIND == 1){
					break outer;
				}
			}
			
			for(Point zb : zbs){
				if(zb != null){
					q.enqueue(zb);
				}
			}
		}

		if(FIND == 0){
			System.out.println("no");
		}else{
			System.out.println(c);
		}
		
	}
	
	/**
	 * 往左走 y--
	 * @param walls
	 * @param bak
	 * @param x
	 * @param y
	 * @param count
	 */
	public static Point left(int[][] walls, int[][] bak, int x, int y, int count){
		//在左边线上
		if(y <= 0){
			return null;
		}
		//往左走
		for(int i=y-1; i>=0; i--){
			int result = check(x, i+1, x, i, walls);
			if(result == 2){
				
				//return new Zb(x, i+1);
				
				if(bak[x][i+1] != -2){
					//queue.enqueue(new Zb(x, y+1));
					bak[x][i+1] = -2;
					return new Point(x, i+1);
				}else{
					return null;
				}
				
			}else if (result == 1) {
				FIND = 1;
				return null;
			}else{
				//如果步数大或者没走过都要设值,入队不设值
				if(bak[x][i] != -2 && (bak[x][i] > count || bak[x][i] == 0)){
					bak[x][i] = count;
				}
			}
		}
		//queue.enqueue(new Zb(x, 0));
		
		if(bak[x][0] == -2){
			return null;
		}else{
			bak[x][0] = -2;
			return new Point(x, 0);
		}
	}
	
	/**
	 * 往下走,x++
	 * @param walls
	 * @param bak
	 * @param x
	 * @param y
	 * @param count
	 */
	public static Point down(int[][] walls, int[][] bak, int x, int y, int count){
		//在下边线上
		if(x >= n-1){
			return null;
		}
		//往下走
		for(int i=x+1; i<n; i++){
			int result = check(i-1, y, i, y, walls);
			if(result == 2){
				//入队
				//queue.enqueue(new Zb(x, i-1));
				//return new Zb(x, i-1);
				if(bak[i-1][y] != -2){
					bak[i-1][y] = -2;
					return new Point(x, i-1);
				}else{
					return null;
				}
				
			}else if (result == 1) {
				FIND = 1;
				return null;
			}else{
				//如果步数大或者没走过都要设值
				if(bak[i][y] != -2 && (bak[i][y] > count || bak[i][y] == 0)){
					bak[i][y] = count;
				}
			}
		}
		//最下边入队
		//queue.enqueue(new Zb(n-1, y));
		
		if(bak[n-1][y] == -2){
			return null;
		}else{
			bak[n-1][y] = -2;
			return new Point(n-1, y);
		}
	}
	
	/**
	 * 往右边走, y++
	 * @param walls
	 * @param bak
	 * @param x
	 * @param y
	 * @param count
	 */
	public static Point right(int[][] walls, int[][] bak, int x, int y, int count){
		//在右边线上
		if(y >= n-1){
			return null;
		}
		//往右走
		for(int i=y+1; i<n; i++){
			int result = check(x, i-1, x, i, walls);
			if (result == 2) {
				//入队
				//queue.enqueue(new Zb(x, i-1));
				//return new Zb(x, i-1);
				if(bak[x][i-1] != -2){
					bak[x][i-1] = -2;
					return new Point(x, i-1);
				}else{
					return null;
				}
				
			} else if (result == 1) {
				FIND = 1;
				return null;
			}else{
				//如果步数大或者没走过都要设值
				if(bak[x][i] != -2 && (bak[x][i] > count || bak[x][i] == 0)){
					bak[x][i] = count;
				}
			}
		}
		//把右边的点加入队列
		//queue.enqueue(new Zb(x, n-1));
	/*	bak[x][n-1] = -2;
		return new Zb(x, n-1);*/
		
		if(bak[x][n-1] == -2){
			return null;
		}else{
			bak[x][n-1] = -2;
			return new Point(x, n-1);
		}
	}

	/**
	 * 往上走,x--
	 * 
	 * @param walls
	 * @param bak
	 * @param x :当前x
	 * @param y :当前y
	 */
	public static Point up(int[][] walls, int[][] bak, int x, int y, int count) {
		//在上边线
		if(x <= 0){
			return null;
		}
		//往上走
		for (int i = x-1; i >= 0; i--) {
			// 检查上面一个点是坑还是墙
			int result = check(i+1, y, i, y, walls);
			if (result == 2) {
				//入队
				//queue.enqueue(new Zb(x, i-1));
				//return new Zb(x, i-1);
				if(bak[i+1][y] != -2){
					bak[i+1][y] = -2;
					return new Point(i+1, y);
				}else{
					return null;
				}
				
				
			} else if (result == 1) {
				FIND = 1;
				return null;
			}else{
				if(bak[i][y] != -2 && (bak[i][y] > count || bak[i][y] == 0)){
					bak[i][y] = count;
				}
			}
		}
		//把到底的点加入队列
		//queue.enqueue(new Zb(0, y));
		
		if(bak[0][y] == -2){
			return null;
		}else{
			bak[0][y] = -2;
			return new Point(0, y);
		}
	}

	/**
	 *2是墙1是坑0是可过 x,y上一个节点 _x,_y下一个节点
	 * 
	 * @param x
	 * @param y
	 * @param _x
	 * @param _y
	 * @param walls
	 * @return
	 */
	public static int check(int x, int y, int _x, int _y, int[][] walls) {
		// 先判断下一步是不是墙,撞到墙是有可能两面性的
		for (int i = 0; i < k; i++) {
			if (x == walls[i][0] && y == walls[i][1] && _x == walls[i][2] && _y == walls[i][3]) {
				return 2;
			}
			
			if (_x == walls[i][0] && _y == walls[i][1] && x == walls[i][2] && y == walls[i][3]) {
				return 2;
			}
		}
		// 如果没有墙在判断是不是坑
		if (pit[0] == _x && pit[1] == _y) {
			return 1;
		}
		// 都不是就说明继续往下走
		return 0;
	}
}
