package 算法分析与设计.回溯法;

import java.util.Arrays;

/**
 * 装载问题:
 * 描述:
 *   有一批共n个集装箱要装上2艘载重量分别为c1和c2的轮船,其中集装箱i的重量为wi,且w1+w2...+wi<=(c1+c2)
 *装载问题要求确定是否有一个合理的装载方案可将整个集装箱装上这2艘轮船,如果有,找出一种装载方案
 * 分析:
 * 1.将第一艘轮船尽可能装满
 * 2.剩余的集装箱装上第二艘轮船
 * 
 * 将第一艘轮船尽可能装满等级与选取全体集装箱的一个子集,使该子集中集装箱重量之和最接近,由此可知,装载问题等价于特殊的0-1背包问题
 * @author Administrator
 *
 */
public class Ex_3_load {
	
	private int c1 = 15;
	private int c2 = 20;
	private int[] N = {3,5,10,4,6,7};
	private int maxValue = 0;
	private int tempValue = 0;
	private int[] way = new int[N.length];
	private int[] bestWay = new int[N.length];
	
	public static void main(String[] args) {
		
		Ex_3_load load = new Ex_3_load();
		load.backTrack(0);
		System.out.println("最终解:" + Arrays.toString(load.bestWay));
		
		for(int i : load.bestWay){
			if(i == 1){
				System.out.println("第" + i + "件货物加入c1");
			}else{
				System.out.println("第" + i + "件货物加入c2");
			}
		}
	}
	
	/**
	 * w1+w2...+wi<=(c1+c2)
	 * @param t
	 */
	public void backTrack(int t){
		//寻找到最底层了
		if(t > N.length-1){
			//System.out.println("可行解:" + Arrays.toString(way));
			if(maxValue < tempValue){
				maxValue = tempValue;
				for(int i=0; i<way.length; i++){
					bestWay[i] = way[i];
				}
			}
			return;
		}
		//条件:之前的重量加上当前的重量要小于c1
		int nowWeight = tempValue + N[t];
		if(nowWeight <= c1){
			//左边的节点符合条件,加入
			tempValue = nowWeight;
			way[t] = 1;
			backTrack(t+1);
			//防止没有找到可行解又回退回来
			tempValue = tempValue - N[t];
			way[t] = 0;
		}
		//右边不加入
		backTrack(t+1);
	}
}
