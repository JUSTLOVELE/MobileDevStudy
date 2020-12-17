package 算法第四版.ch03.p02.散列表;
/**
 * 基于线性探测法的散列表
 *  实现散列表的另一种方式就是用大小为M的数组保存N个键值对,其中M>N,我们需要依靠数组中的空位解决碰撞冲突,基于
 *这种策略的所有方法被统称为开放地址散列表
 *  开放地址散列表中的最简单的方法叫做线性探测法:当碰撞发生时(当一个键的散列值已经被另一个不同的键占用),我们直接检查散列表中的下一个位置,
 *这样的线性探测可能会产生三种结果:
 *  1.命中:该位置的键和被查找的键相同
 *  2.未命中,键为空
 *  3.继续查找,该位置的键和被查找的键不同(到达数组结尾时折回数组的开头)
 *  
 * 开发地址类的散列表的核心思想是与其将内存用作链表,不如将它们作为在散列表的空元素,这些空元素可以作为查找结束的标志
 * @author yangzuliang
 *
 */
public class LinearProbingHashST<Key, Value> {

	private int N;
	private int M = 16;
	private Key[] keys;
	private Value[] vals;
	
	public LinearProbingHashST(){
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	public LinearProbingHashST(int cap){
		M = cap;
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff)%M;
	}
	
	private void resize(int cap){
		
		LinearProbingHashST<Key, Value> t = new LinearProbingHashST<Key, Value>(cap);
		for(int i=0; i<M; i++){
			if(keys[i] != null){
				t.put(keys[i], vals[i]);
			}
		}
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	
	/**
	 * 直接置为空是不行的,因为这会使得在此位置之后的元素无法被查找
	 * @param key
	 */
	public void delete(Key key){
		
		if(!contains(key)){
			return;
		}
		int i=hash(key);
		while(!key.equals(keys[i])){
			i = (i+1)%M;
		}
		keys[i] = null;
		vals[i] = null;
		i = (i+1)%M;
		while(keys[i] != null){
			Key keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRedo, valToRedo);
			i = (i+1)%M;
		}
		N--;
		if(N>0 && N== M/8){
			resize(M/2);
		}
	}
	
	public void put(Key key, Value val){
		
		if(N >=M/2){
			resize(2*M);
		}
		int i;
		for(i=hash(key); keys[i]!=null; i=(i+1)%M){
			if(keys[i].equals(key)){
				vals[i] = val;
				return ;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public boolean contains(Key key){
		Value val = get(key);
		return val == null?false:true;
	}
	
	public Value get(Key key){
		
		for(int i=hash(key); keys[i] != null; i=(i+1)%M){
			if(keys[i].equals(key)){
				return vals[i];
			}
		}
		
		return null;
	}
}
