package com.arithmetic.深度优先和广度优先;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先:邻接表
 * @author yangzuliang
 *
 */
public class DFS_algorithm_list {
	
	private class HeadNode{
		
		public String value;
		
		public ArcNode firstArcNode;
		
		public boolean isVisited;
	}
	
	private class ArcNode{
		
		public HeadNode headNode;
		
		public ArcNode nextArcNode;
		
		public ArcNode( HeadNode headNode){
			
			this.headNode = headNode;
		}
	}
	
	public void addArc(HeadNode head, HeadNode tail){
		
		if(head.firstArcNode == null){
			
			head.firstArcNode = new ArcNode(tail);
		}else{
			
			ArcNode arcNode = head.firstArcNode;
			
			while(arcNode.nextArcNode != null){
				
				arcNode = arcNode.nextArcNode;
			}
			
			arcNode.nextArcNode = new ArcNode(tail);
		}
	}
	
	public List<HeadNode> headNodes = new ArrayList<HeadNode>();
	
	public void DFSTraverse(){
		
		for(HeadNode node : headNodes){
			
			node.isVisited = false;
		}
		
		for(int i=0; i<headNodes.size(); i++){
			
			if(!headNodes.get(i).isVisited){
				
				DFS(headNodes.get(i));
			}
		}
		
		
	}
	
	private void DFS(HeadNode node){
		
		node.isVisited = true;
		System.out.print(node.value + "->");
		ArcNode arcNode = node.firstArcNode;
		
		while(arcNode != null){
			
			if(!arcNode.headNode.isVisited){
				
				DFS(arcNode.headNode);
			}
			
			arcNode = arcNode.nextArcNode;
		}
	}
	
	public static void main(String[] args) {
		
		DFS_algorithm_list.HeadNode hA = new DFS_algorithm_list().new HeadNode();
		hA.value = "A";
		DFS_algorithm_list.HeadNode hB = new DFS_algorithm_list().new HeadNode();
		hB.value = "B";
		DFS_algorithm_list.HeadNode hC = new DFS_algorithm_list().new HeadNode();
		hC.value = "C";
		DFS_algorithm_list.HeadNode hD = new DFS_algorithm_list().new HeadNode();
		hD.value = "D";
		DFS_algorithm_list dfs_algorithm_list = new DFS_algorithm_list();
		dfs_algorithm_list.headNodes.add(hA);
		dfs_algorithm_list.headNodes.add(hB);
		dfs_algorithm_list.headNodes.add(hC);
		dfs_algorithm_list.headNodes.add(hD);
		dfs_algorithm_list.addArc(hA, hB);
		dfs_algorithm_list.addArc(hB, hC);
		dfs_algorithm_list.addArc(hC, hD);
		dfs_algorithm_list.addArc(hB, hA);
		dfs_algorithm_list.addArc(hA, hC);
		dfs_algorithm_list.addArc(hC, hB);
		dfs_algorithm_list.addArc(hB, hA);
		dfs_algorithm_list.addArc(hA, hD);
		dfs_algorithm_list.addArc(hD, hA);
		dfs_algorithm_list.addArc(hA, hC);
		dfs_algorithm_list.DFSTraverse();
	}
}
