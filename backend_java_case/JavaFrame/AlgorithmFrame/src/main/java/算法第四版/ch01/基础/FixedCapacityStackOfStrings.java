package 算法第四版.ch01.基础;

public class FixedCapacityStackOfStrings {
	
	private String[] a;
	
	private int N;
	
	public FixedCapacityStackOfStrings(int cap){
		
		a = new String[cap];
	}
	
	public boolean isEmpty(){
		
		return N == 0;
	}
	
	public int size(){
		
		return N;
	}
	
	public void push(String item){
		
		a[N++] = item;
	}
	
	public String pop(){
		
		return a[--N];
	}
	
	public boolean isFull(){
		
		return a.length == N;
	}

}
