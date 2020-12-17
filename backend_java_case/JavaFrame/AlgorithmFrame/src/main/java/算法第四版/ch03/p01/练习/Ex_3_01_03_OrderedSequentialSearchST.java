package �㷨���İ�.ch03.p01.��ϰ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ����һ�����ű��ʵ��Ex_3_01_03_OrderedSequentialSearchST,ʹ������������ʵ�����ǵ�������ű�API
 * @author yangzuliang
 *
 */

interface OrderedSequentialSearchST<Value>{
	
	void ST();
	void put(Value val);
	Value get(int key);
	void delete(int key);
	boolean contains(Value key);
	boolean isEmpty();
	int size();
	Iterator<Integer> keys();
}

public class Ex_3_01_03_OrderedSequentialSearchST<Value> implements OrderedSequentialSearchST<Value>{

	private List<Value> list;
	private int size = 0;
	
	
	@Override
	public void ST() {
		// TODO Auto-generated method stub
		list = new ArrayList<Value>();
	}

	@Override
	public void put(Value val) {
		// TODO Auto-generated method stub
		if(!list.contains(val)){
			list.add(val);
		}
	}

	@Override
	public Value get(int key) {
		// TODO Auto-generated method stub
		return list.get(key);
	}

	@Override
	public void delete(int key) {
		// TODO Auto-generated method stub
		list.remove(key);
	}

	@Override
	public boolean contains(Value key) {
		// TODO Auto-generated method stub
		return list.contains(key);
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
		return null;
	}

}
