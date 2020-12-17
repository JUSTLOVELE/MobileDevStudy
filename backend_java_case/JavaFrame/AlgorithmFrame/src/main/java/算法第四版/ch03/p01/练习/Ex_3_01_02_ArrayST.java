package �㷨���İ�.ch03.p01.��ϰ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ����һ�����ű��ʵ��ArrayST,ʹ��(����������ʵ�����ǵĻ���API)
 * 
 *  ST():����һ�ŷ��ű�
 void put(Key key, Value val)
 Value get(Key key)
 void delete(Key key)
 boolean contains(Key key)
 boolean isEmpty()
 int size()
 Iterable<Key> keys()
 * @author yangzuliang
 *
 */

interface ArrayST<Value>{
	
	void ST(int capacity);
	void put(Value val);
	Value get(int key);
	void delete(int key);
	boolean contains(int key);
	boolean isEmpty();
	int size();
	Iterator<Integer> keys();
}

public class Ex_3_01_02_ArrayST<Value> implements ArrayST<Value>{
	
	private Object[] objs;
	private int size = 0;

	@Override
	public void ST(int capacity) {
		// TODO Auto-generated method stub
		objs = new Object[capacity];
	}

	@Override
	public void put(Value val) {
		// TODO Auto-generated method stub
		objs[size] = val;
		size += 1;
	}

	@Override
	public Value get(int i) {
		// TODO Auto-generated method stub
		return (Value) objs[i];
	}

	@Override
	public void delete(int key) {
		// TODO Auto-generated method stub
		objs[key] = null;
		size--;
	}

	@Override
	public boolean contains(int key) {
		// TODO Auto-generated method stub
		return objs[key] != null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Iterator<Integer> keys() {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<objs.length; i++){
			
			if(objs[i] != null){
				list.add(i);
			}
		}
		
		return list.iterator();
	}

}
