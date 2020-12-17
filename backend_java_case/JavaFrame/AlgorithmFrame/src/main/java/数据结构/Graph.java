package 数据结构;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接链表抽象实现(图)
 * @author Administrator
 *
 */
public class Graph {
	
	public enum ColorEnum{
		WHITE, GRAY, BLACK;
	}
	
	public List<Node> vList = new ArrayList<Node>();
	public int V;//顶点数
	public int E;//边数

}
