package �㷨���������.��ҵ6;

import �㷨���İ�.ch01.����.Queue;

public class Airroute {

	static int K; //�ֽ�
	static int N; //N������
	static int R; //R����·
	static int minL = 10000000;//��С·��
	//static int T; //·��
	//static int COST; //����
	static int FIND = 0;
	static Queue<Integer> Q = new Queue<Integer>();//����
	static Queue<Integer> M = new Queue<Integer>();//���ѽ�Ǯ
	static Queue<Integer> S = new Queue<Integer>();//�ߵ������ķѵľ���
	
	public static void main(String[] args) {
		K=5;
		N=6;
		R=8;
		int[][] airs = init();
		
		for(int i=0; i<R; i++){
			//������ֻ����1,�ӵ�һ�������
			if(airs[i][0] == 1){
				int next = airs[i][1];//��һ��վ��
				System.out.print("��һ��վ��:" + next);
				int COST = airs[i][3];//����
				int T = airs[i][2];//·��
				System.out.print(";����:" + COST + ";��·��:" + T);
				//��һ�λ���Ǯ�ͳ�����K�϶���over��
				if(COST > K){
					continue;
				}
				//��һ�ξ��ҵ�Ŀ��
				if(next == N){
					if(minL > T){
						minL = N;
						FIND = 1;//�ҵ���
					}
				}else{
					System.out.println();
					//�ѳ�����Ϊ1�Ľڵ����ն���
					Q.clear();
					M.clear();
					S.clear();
					Q.enqueue(next);
					M.enqueue(airs[i][3]);
					S.enqueue(airs[i][2]);
					System.out.println("��һ���Ҳ���,��ʼ������ѯ��һ���ڵ�Ϊ" + next);
					while(!Q.isEmpty()){
						next = Q.dequeue();
						int currentCost = M.dequeue();//��ǰ����
						int currentS = S.dequeue();
						for(int j=0; j<R; j++){
							//�ҵ���һ����Ϊnext�ķɻ�
							if(next == airs[j][0]){
								int cost = currentCost + airs[j][3];//�����·���һ�����Ǯ
								int t = currentS + airs[j][2];//�������һ�����·��
								int n = airs[j][1];//�ҵ���һ����
								//����ҵ�
								if(n == N){
									FIND = 1;
									int r = find(cost, t);
									if(r == 1){
										minL = t;
										System.out.println("�ҵ���,����:" + cost + ";·��:" + t);
									}
									
								}else{
									//û���ҵ�
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
			//����к��౻�ҵ��˾��ٱȽ���·��,û���ҵ�ֱ�����
			if(FIND == 1){
				//�����ǰ·���ܺ���С��minL˵������·OK
				if(minL > t){
					System.out.println("�ҵ���һ���ڵ�:" + next + ";�ķѽ�Ǯ:" +cost + ";�ķ�·��:" + t);
					Q.enqueue(next);
					M.enqueue(cost);
					S.enqueue(t);
				}else{
					System.out.println("��С·��Ϊ:" + minL + ";��ǰ·��Ϊ:" + t);
				}
			}else{
				System.out.println("�ҵ���һ���ڵ�:" + next + ";�ķѽ�Ǯ:" +cost + ";�ķ�·��:" + t);
				Q.enqueue(next);
				M.enqueue(cost);
				S.enqueue(t);
			}
		}else{
			System.out.println("��ǰ����K");
		}
	}
	
	/**
	 * �ҵ����ж��ǲ��ǿ��Խ���
	 * @param cost
	 * @param t
	 * @return
	 */
	private static int find(int cost, int t){
		
		if(cost < K){
			//����к��౻�ҵ��˾��ٱȽ���·��
			if(FIND == 1){
				//�����ǰ·���ܺ���С��minL˵������·OK
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
