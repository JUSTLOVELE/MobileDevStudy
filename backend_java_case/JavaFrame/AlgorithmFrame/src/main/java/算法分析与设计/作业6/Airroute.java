package 算法分析与设计.作业6;

import 算法第四版.ch01.基础.Queue;

public class Airroute {

	static int K; //现金
	static int N; //N个城市
	static int R; //R条道路
	static int minL = 10000000;//最小路径
	//static int T; //路径
	//static int COST; //花费
	static int FIND = 0;
	static Queue<Integer> Q = new Queue<Integer>();//航班
	static Queue<Integer> M = new Queue<Integer>();//花费金钱
	static Queue<Integer> S = new Queue<Integer>();//走到这个点耗费的距离
	
	public static void main(String[] args) {
		K=5;
		N=6;
		R=8;
		int[][] airs = init();
		
		for(int i=0; i<R; i++){
			//出发点只能是1,从第一个点出发
			if(airs[i][0] == 1){
				int next = airs[i][1];//下一个站点
				System.out.print("下一个站点:" + next);
				int COST = airs[i][3];//花费
				int T = airs[i][2];//路程
				System.out.print(";花费:" + COST + ";总路程:" + T);
				//第一次花的钱就超过了K肯定就over了
				if(COST > K){
					continue;
				}
				//第一次就找到目标
				if(next == N){
					if(minL > T){
						minL = N;
						FIND = 1;//找到了
					}
				}else{
					System.out.println();
					//把出发点为1的节点加入空队列
					Q.clear();
					M.clear();
					S.clear();
					Q.enqueue(next);
					M.enqueue(airs[i][3]);
					S.enqueue(airs[i][2]);
					System.out.println("第一次找不到,开始遍历查询下一个节点为" + next);
					while(!Q.isEmpty()){
						next = Q.dequeue();
						int currentCost = M.dequeue();//当前花费
						int currentS = S.dequeue();
						for(int j=0; j<R; j++){
							//找到下一个点为next的飞机
							if(next == airs[j][0]){
								int cost = currentCost + airs[j][3];//计算下飞下一个点的钱
								int t = currentS + airs[j][2];//计算飞下一个点的路程
								int n = airs[j][1];//找到下一个点
								//如果找到
								if(n == N){
									FIND = 1;
									int r = find(cost, t);
									if(r == 1){
										minL = t;
										System.out.println("找到了,花费:" + cost + ";路程:" + t);
									}
									
								}else{
									//没有找到
									noFind(cost, t, n);
								}
							}
						}
					}
				}
			}
		}
		
		if(FIND == 0){
			System.out.println(-1);
		}else{
			System.out.println(minL);
		}
	}
	
	private static void noFind(int cost, int t, int next){
		
		if(cost < K){
			//如果有航班被找到了就再比较下路程,没有找到直接入队
			if(FIND == 1){
				//如果当前路径总和是小于minL说明这条路OK
				if(minL > t){
					System.out.println("找到下一个节点:" + next + ";耗费金钱:" +cost + ";耗费路程:" + t);
					Q.enqueue(next);
					M.enqueue(cost);
					S.enqueue(t);
				}else{
					System.out.println("最小路程为:" + minL + ";当前路程为:" + t);
				}
			}else{
				System.out.println("找到下一个节点:" + next + ";耗费金钱:" +cost + ";耗费路程:" + t);
				Q.enqueue(next);
				M.enqueue(cost);
				S.enqueue(t);
			}
		}else{
			System.out.println("当前金额超过K");
		}
	}
	
	/**
	 * 找到了判断是不是可以结束
	 * @param cost
	 * @param t
	 * @return
	 */
	private static int find(int cost, int t){
		
		if(cost < K){
			//如果有航班被找到了就再比较下路程
			if(FIND == 1){
				//如果当前路径总和是小于minL说明这条路OK
				if(minL > t){
					return 1;
				}
			}
		}
		return 0;
	}
	
	private static int[][] init(){
		int [][] airs = new int[8][4];
		airs[0][0] = 1;
		airs[0][1] = 2;
		airs[0][2] = 2;
		airs[0][3] = 4;
		
		airs[1][0] = 1;
		airs[1][1] = 2;
		airs[1][2] = 1;
		airs[1][3] = 2;
		
		airs[2][0] = 2;
		airs[2][1] = 4;
		airs[2][2] = 3;
		airs[2][3] = 3;
		
		airs[3][0] = 3;
		airs[3][1] = 4;
		airs[3][2] = 2;
		airs[3][3] = 4;
		
		airs[4][0] = 1;
		airs[4][1] = 3;
		airs[4][2] = 4;
		airs[4][3] = 1;
		
		airs[5][0] = 4;
		airs[5][1] = 6;
		airs[5][2] = 2;
		airs[5][3] = 1;
		
		airs[6][0] = 3;
		airs[6][1] = 5;
		airs[6][2] = 2;
		airs[6][3] = 0;
		
		airs[7][0] = 5;
		airs[7][1] = 4;
		airs[7][2] = 3;
		airs[7][3] = 2;
		
		return airs;
	}
}
