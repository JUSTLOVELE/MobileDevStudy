package �㷨���������.��ҵ6;

import java.util.ArrayList;
import java.util.List;

import �㷨���İ�.ch01.����.Queue;

/**
 * ������Ϸ ����˼·: Ҫ�ҵ�����һ�»�������һ��
 * 
 * @author Administrator
 * 
 */
public class Slider3 {

	static int n;
	static int k;
	static int[] slider = new int[2];//��������
	static int[] pit = new int[2];//�ӵ�����
	static int FIND = 0;//��FIND = 1ʱ��ʾ�Ѿ��ҵ���
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
		// ����Ӻͻ���һ��λ��,��ֱ�����0����
		if (slider[0] == pit[0] && slider[1] == pit[1]) {
			System.out.println(0);
			return;
		}

		int[][] bak = new int[n][n];// ��������
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
					System.out.println("�ϱ�:" + zbUp.toString());
				}
				if(FIND == 1){
					break outer;
				}
				
				Point zuRight = right(walls, bak, point.getX(), point.getY(), c);
				if(zuRight != null){
					zbs.add(zuRight);
					System.out.println("�ұ�:" + zuRight.toString());
				}
				
				if(FIND == 1){
					break outer;
				}
				
				Point zbDown = down(walls, bak, point.getX(), point.getY(), c);
				if(zbDown != null){
					zbs.add(zbDown);
					System.out.println("�±�:" + zbDown.toString());
				}
				
				if(FIND == 1){
					break outer;
				}
				
				Point zbLeft = left(walls, bak, point.getX(), point.getY(), c);
				if(zbLeft != null){
					zbs.add(zbLeft);
					System.out.println("���:" + zbLeft.toString());
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
	 * ������ y--
	 * @param walls
	 * @param bak
	 * @param x
	 * @param y
	 * @param count
	 */
	public static Point left(int[][] walls, int[][] bak, int x, int y, int count){
		//���������
		if(y <= 0){
			return null;
		}
		//������
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
				//������������û�߹���Ҫ��ֵ,��Ӳ���ֵ
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
	 * ������,x++
	 * @param walls
	 * @param bak
	 * @param x
	 * @param y
	 * @param count
	 */
	public static Point down(int[][] walls, int[][] bak, int x, int y, int count){
		//���±�����
		if(x >= n-1){
			return null;
		}
		//������
		for(int i=x+1; i<n; i++){
			int result = check(i-1, y, i, y, walls);
			if(result == 2){
				//���
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
				//������������û�߹���Ҫ��ֵ
				if(bak[i][y] != -2 && (bak[i][y] > count || bak[i][y] == 0)){
					bak[i][y] = count;
				}
			}
		}
		//���±����
		//queue.enqueue(new Zb(n-1, y));
		
		if(bak[n-1][y] == -2){
			return null;
		}else{
			bak[n-1][y] = -2;
			return new Point(n-1, y);
		}
	}
	
	/**
	 * ���ұ���, y++
	 * @param walls
	 * @param bak
	 * @param x
	 * @param y
	 * @param count
	 */
	public static Point right(int[][] walls, int[][] bak, int x, int y, int count){
		//���ұ�����
		if(y >= n-1){
			return null;
		}
		//������
		for(int i=y+1; i<n; i++){
			int result = check(x, i-1, x, i, walls);
			if (result == 2) {
				//���
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
				//������������û�߹���Ҫ��ֵ
				if(bak[x][i] != -2 && (bak[x][i] > count || bak[x][i] == 0)){
					bak[x][i] = count;
				}
			}
		}
		//���ұߵĵ�������
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
	 * ������,x--
	 * 
	 * @param walls
	 * @param bak
	 * @param x :��ǰx
	 * @param y :��ǰy
	 */
	public static Point up(int[][] walls, int[][] bak, int x, int y, int count) {
		//���ϱ���
		if(x <= 0){
			return null;
		}
		//������
		for (int i = x-1; i >= 0; i--) {
			// �������һ�����ǿӻ���ǽ
			int result = check(i+1, y, i, y, walls);
			if (result == 2) {
				//���
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
		//�ѵ��׵ĵ�������
		//queue.enqueue(new Zb(0, y));
		
		if(bak[0][y] == -2){
			return null;
		}else{
			bak[0][y] = -2;
			return new Point(0, y);
		}
	}

	/**
	 *2��ǽ1�ǿ�0�ǿɹ� x,y��һ���ڵ� _x,_y��һ���ڵ�
	 * 
	 * @param x
	 * @param y
	 * @param _x
	 * @param _y
	 * @param walls
	 * @return
	 */
	public static int check(int x, int y, int _x, int _y, int[][] walls) {
		// ���ж���һ���ǲ���ǽ,ײ��ǽ���п��������Ե�
		for (int i = 0; i < k; i++) {
			if (x == walls[i][0] && y == walls[i][1] && _x == walls[i][2] && _y == walls[i][3]) {
				return 2;
			}
			
			if (_x == walls[i][0] && _y == walls[i][1] && x == walls[i][2] && y == walls[i][3]) {
				return 2;
			}
		}
		// ���û��ǽ���ж��ǲ��ǿ�
		if (pit[0] == _x && pit[1] == _y) {
			return 1;
		}
		// �����Ǿ�˵������������
		return 0;
	}
}
