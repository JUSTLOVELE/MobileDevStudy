package 算法第四版.ch03.p01.符号表;

import 算法第四版.ch01.基础.Iterable;
import 算法第四版.ch01.基础.Queue;

/**
 * 二分查找(基于有序数组)
 *  尽管能够保证查找所需的时间都是对数级别的,但是BinarySearchST仍然无法支撑大型文体,
 *二分查找减少了比较的次数但无法减少运行所需时间,因为它无法改变以下事实:在键是随机排列的情况
 *下,构造一个基于有序数组的符号表所需要访问数组的次数是数组长度的平方级别
 * @author yangzuliang
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	//练习3.1.17
	public Key floor(Key key){
		
		if(key == null){
			throw new NullPointerException();
		}
		
		int i= rank(key);
	    if(i<N && key.compareTo(keys[i]) == 0){
	    	return keys[i];
	    }else{
	    	return keys[i-1];
	    }
	}
	
	public void delete(Key key){
		
		if(key == null){
			throw new NullPointerException("argument to delete() is null");
		}
		
		if(isEmpty()) {
			return;
		}
		
		int i = rank(key);
		
		if(i == N || keys[i].compareTo(key) != 0){
			return;
		}
		
		for (int j = i; j < N-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        N--;
        keys[N] = null;  // to avoid loitering
        vals[N] = null;
		
        if (N > 0 && N == keys.length/4) resize(keys.length/2);

        assert check();
	}
	
	public void deleteMin(){
		delete(min());
	}
	
	public void deleteMax(){
		delete(max());
	}
	
	public BinarySearchST(){
		this(INIT_CAPACITY);
	}
	
	public BinarySearchST(int capacity){
		keys = (Key[]) new Comparable[capacity];
	    vals = (Value[]) new Object[capacity];
	}
	
	public boolean contains(Key key){
		
		if(key == null){
			throw new NullPointerException("argument to contains() is null");
		}
		return get(key) != null;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int capacity){
		
		assert capacity >= N;
		Key[] tempk = (Key[]) new Comparable[capacity];
		Value[] tempv = (Value[]) new Object[capacity];
		
		for(int i=0; i<N; i++){
			tempk[i] = keys[i];
			tempv[i] = vals[i];
		}
		
		vals = tempv;
		keys = tempk;
	}
	
	public Value get(Key key){
		if(isEmpty()){
			return null;
		}
		int i=rank(key);
		if(i<N && keys[i].compareTo(key) == 0){
			return vals[i];
		}else{
			return null;
		}
	}
	
	public boolean isEmpty(){
		
		return size() == 0;
	}
	
	public Key min(){
		return keys[0];
	}
	
	public Key max(){
		return keys[N-1];
	}
	
	public Key select(int k){
		return keys[k];
	}
	
	public Key ceiling(Key key){
		int i = rank(key);
		
		if(i == N){
			return null;
		}
		
		return keys[i];
	}
	
	/**
	 * 返回表中小于给定键的键的数量
	 * @param key
	 * @return
	 */
	public int rank(Key key){
		int lo = 0;
	    int hi = N-1;
	    while(lo<=hi){
	    	int mid = lo+(hi-lo)/2;
	    	int cmp = key.compareTo(keys[mid]);
	    	if(cmp<0) {
	    		hi = mid -1;
	    	}else if(cmp > 0){
	    		lo = mid + 1;
	    	}else{
	    		return mid;
	    	}
	    }
	    
	    return lo;
	}
	
	/**
	 * 查找键,找到则更新至,否则创建新的元素
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val){
		
		if(key == null){
			throw new NullPointerException("first argument to put() is null");
		}
		
		if(val == null){
			delete(key);
			return;
		}
		
		int i= rank(key);
		
		if(i<N && keys[i].compareTo(key) == 0){
			vals[i] = val; 
			return ;
		}
		
		if(N == keys.length){
			resize(2*keys.length);
		}
		
		for(int j=N; j>i; j--){
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		
		keys[i] = key;
		vals[i] =val;
		N++;
		
		assert check();
	}
	
    public Iterable<Key> keys(Key lo, Key hi){
		
		Queue<Key> q = new Queue<Key>();
		
		for(int i=rank(lo); i<=rank(hi); i++){
			q.enqueue(keys[i]);
		}
		
		return q;
	}
    
    public Iterable<Key> keys(){
    	return keys(min(), max());
    }
    
    private boolean check(){
    	return isSorted() && rankCheck();
    }
    
    private boolean isSorted(){
    	 for (int i = 1; i < size(); i++)
             if (keys[i].compareTo(keys[i-1]) < 0) return false;
         return true;
    }
    
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        return true;
    }
    
    public static void main(String[] args) { 
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
    }
}
