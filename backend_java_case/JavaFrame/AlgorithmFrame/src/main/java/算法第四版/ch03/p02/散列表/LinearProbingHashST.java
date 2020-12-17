package �㷨���İ�.ch03.p02.ɢ�б�;
/**
 * ��������̽�ⷨ��ɢ�б�
 *  ʵ��ɢ�б����һ�ַ�ʽ�����ô�СΪM�����鱣��N����ֵ��,����M>N,������Ҫ���������еĿ�λ�����ײ��ͻ,����
 *���ֲ��Ե����з�����ͳ��Ϊ���ŵ�ַɢ�б�
 *  ���ŵ�ַɢ�б��е���򵥵ķ�����������̽�ⷨ:����ײ����ʱ(��һ������ɢ��ֵ�Ѿ�����һ����ͬ�ļ�ռ��),����ֱ�Ӽ��ɢ�б��е���һ��λ��,
 *����������̽����ܻ�������ֽ��:
 *  1.����:��λ�õļ��ͱ����ҵļ���ͬ
 *  2.δ����,��Ϊ��
 *  3.��������,��λ�õļ��ͱ����ҵļ���ͬ(���������βʱ�ۻ�����Ŀ�ͷ)
 *  
 * ������ַ���ɢ�б�ĺ���˼�������佫�ڴ���������,���罫������Ϊ��ɢ�б�Ŀ�Ԫ��,��Щ��Ԫ�ؿ�����Ϊ���ҽ����ı�־
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
	 * ֱ����Ϊ���ǲ��е�,��Ϊ���ʹ���ڴ�λ��֮���Ԫ���޷�������
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
