package 算法第四版.ch04.p01.无向图.dfs;

public interface Paths {
	
	/**
	 * 是否存在从s到v的路径
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v);
	
	/**
	 * s到v的路径,如果不存在则返回null
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v);
}
