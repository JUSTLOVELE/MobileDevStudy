package �㷨���İ�.ch04.p01.����ͼ.dfs;

public interface Paths {
	
	/**
	 * �Ƿ���ڴ�s��v��·��
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v);
	
	/**
	 * s��v��·��,����������򷵻�null
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v);
}
