package 迭代器模式;

import java.util.List;

public class PancakeHouseMenuIterator implements Iterator{
	
	private List list;
	
	private int i = 0;
	
	public PancakeHouseMenuIterator(List list){
		
	   this.list = list;
	}

	@Override
	public boolean hasNext() {
		
		if(list != null){
			
			if(list.size() >= i){
				
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Object next() {
		
		if(list != null){
			
			if(list.size() >= i){
				
				i++;
				
				return list.get(i);
			}
		}
		
		return null;
	}

}
