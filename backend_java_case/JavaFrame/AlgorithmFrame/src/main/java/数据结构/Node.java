package ���ݽṹ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * �ڵ�
 * @author Administrator
 *
 */
public class Node {
	
	public List<Node> list = new ArrayList<Node>();
	
	public Graph.ColorEnum color;
	
	public int weight = 1;//Ȩֵ
	
	public String name;
	
	public int d = 0;//��ʾԴ�ڵ㵽�׶�x֮��ľ���,��Ȼ��ʼֵԴ�ڵ㵽Դ�ڵ�ľ���Ϊ0
	
	public Node pioneer; //ǰ���ڵ�
	
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
