package 迭代器模式;

public class DinnerMenuIterator implements Iterator {
	
	MenuItem[] items;
	
	int position = 0;
	
	public DinnerMenuIterator(MenuItem[] items){
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(position >= items.length || items[position] == null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}

}
