package �㷨���İ�.ch04.p02.����ͼ.��������;

import �㷨���İ�.ch04.p02.����ͼ.Digraph;
import �㷨���İ�.ch04.p02.����ͼ.DirectedCycle;

/**
 * ��������
 *   ���ȼ������µĵ�������ȼ��ڼ��������޻�ͼ�е����ж������������
 *   ���ҽ�����һ������ͼ���޻�ͼʱ�����ܽ�����������
 *   ���ǽ�ѧϰ�ܹ��������������޻�ͼ����������
 * 
 * ����෵��һ�������޻�ͼ����������(ʹ�������������),�ڰ�����ʱhasorder�᷵��false
 * һ�������޻�ͼ����������Ϊ���ж�������������
 * 
 *  �ķ�ʱ���V+E������
 * @author yangzuliang
 *
 */
public class Topological {

	private Iterable<Integer> order;
	
	private int[] rank;
	
	/**
	 * 1.ָ����������ȼ�����
	 * 2.���ϼ�Ⲣȥ������ͼ�е����л�,��ȷ�����ڿ��з���
	 * 3.ʹ��������������������
	 * ���Ƶ�,���ȷ������κα䶯֮����Ҫ�ٴμ���Ƿ���ڻ�,Ȼ���ټ����µĵ��Ȱ���
	 * @param G
	 */
	public Topological(Digraph G){
		
		DirectedCycle cyclefinder = new DirectedCycle(G);
		
		if(!cyclefinder.hasCycle()){
			
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
			rank = new int[G.V()];
			int i=0;
			
			for(int v:order){
				rank[v] = i++;
			}
		}
	}
	
   /* public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }*/
	
    private void validateVertex(int v) {
        int V = rank.length;
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }
    
    public int rank(int v){
    	
    	validateVertex(v);
    	
    	if(hasOrder()){
    		return rank[v];
    	}else{
    		return -1;
    	}
    }
	
	public Iterable<Integer> order(){
		return order;
	}
	
	public boolean hasOrder(){
		return order != null;
	}
}
