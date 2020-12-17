package 算法第四版.ch04.p03.最小生成树;

/**
 * 加权边
 * @author yangzuliang
 *
 */
public class Edge implements Comparable<Edge>{

	private final int v;
	private final int w;
	private final double weight;
	
	public static void main(String[] args) {
		
		 Edge e = new Edge(12, 34, 5.67);
		 System.out.println(e.toString());
	}
	
	public Edge(int v, int w, double weight){
		
		if (v < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (w < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
	}
	
	public double weight(){
		return weight;
	}
	
	public int either(){
		return v;
	}
	
	public int other(int vertex){
		
		if(vertex == v){
			return w;
		}else if(vertex == w){
			return v;
		}else{
			 throw new IllegalArgumentException("Illegal endpoint");
		}
	}
	
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return Double.compare(this.weight, o.weight);
	}

	public String toString(){
		return String.format("%d-%d %.5f", v, w, weight);
	}
}
