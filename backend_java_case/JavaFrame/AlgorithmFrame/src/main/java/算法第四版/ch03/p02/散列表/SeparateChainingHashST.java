package �㷨���İ�.ch03.p02.ɢ�б�;

import �㷨���İ�.ch03.p01.���ű�.SequentialSearchST;

/**
 * ������������ɢ�б�(HashMap)
 *   ��ײ����,Ҳ���Ǵ���������������ɢ����ͬ�����,����СΪM�������е�ÿ��Ԫ��ָ��һ������,�����е�ÿ���ڵ㶼�洢��ɢ��ֵΪ��Ԫ�ص������ļ�ֵ��
 *���ַ�����Ϊ������
 *  ����:1.����ɢ��ֵ�ҵ���Ӧ������;2.Ȼ����������˳�������Ӧ�ļ�
 *  
 *  ��ʵ�ֻ�����������ɢ�б�ʱ,���ǵ�Ŀ����ѡ���ʵ��������СM,�Ȳ�����Ϊ��������˷Ѵ����ڴ�,Ҳ������Ϊ����̫�����ڲ������˷�̫��ʱ��,
 *����������һ���ô������Ⲣ���ǹؼ��Ե�ѡ��,�������ļ�����Ԥ��,���������ʱ��ֻ���ѡ�����������Գ�;�������Ԥ��,��Ȼ��Щ�ռ��˷�
 *�����һ�ǳ���
 *
 *  ɢ�е���ҪĿ���Ǿ��ȵĽ���ɢ������,����ڼ���ɢ�к����˳����Ϣ�Ͷ�ʧ��,�����������С�� ����ĳ����Χ�ٶȶ���һ�����
 *  
 *  
 * @author yangzuliang
 *
 * @param <Key>
 * @param <Value>
 */
public class SeparateChainingHashST<Key, Value> {

	private int N;
	private int M;
	private SequentialSearchST<Key, Value>[] st;
	
	public SeparateChainingHashST(){
		this(997);
	}
	
	public SeparateChainingHashST(int M){
		//����M������
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i=0; i<M; i++)
			st[i] = new SequentialSearchST<Key, Value>();
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7ffffff)%M;
	}
	
	public Value get(Key key){
		return (Value) st[hash(key)].get(key);
	}
	
	public void put(Key key, Value val){
		st[hash(key)].put(key, val);
	}
	
	public Iterable<Key> keys(){
		return null;
	}
	
	public static void main(String[] args) {
		SeparateChainingHashST<String, String> st = new SeparateChainingHashST<String, String>();
		st.put("test", "value");
		String s = st.get("test");
		System.out.println(s);
	}
}
