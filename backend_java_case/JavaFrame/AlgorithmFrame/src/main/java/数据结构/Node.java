package 数据结构;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 节点
 * @author Administrator
 *
 */
public class Node {
	
	public List<Node> list = new ArrayList<Node>();
	
	public Graph.ColorEnum color;
	
	public int weight = 1;//权值
	
	public String name;
	
	public int d = 0;//表示源节点到阶段x之间的距离,显然初始值源节点到源节点的距离为0
	
	public Node pioneer; //前驱节点
	
	public Node(int weight, String name){
		this.weight = weight;
		this.name = name;
	}
	
	/*private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	
	public void setNode(Node next, Node first, int weight){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("next", next);
		map.put("first", first);
		map.put("weight", weight);
		list.add(map);
	}*/
	
	
}
