package 算法第四版.ch01.练习;

/**
 * P108 使用定长数组实现队列的抽象,然后扩展实现使用调整数组的大小突破大小的限制
 * @author yangzuliang
 *
 */
public class ResizingArrayQuenueOfStrings {
    /**队头**/
	private int front = 0; 
    /**队尾**/
	private int rear = 0;
	
	private int length = 4;
	
	private Integer [] objs = new Integer[length];
	
	public boolean isEmpty(){
		
		return rear == 0;
	}
	
	public void enqueue(Integer item){
		
		if(rear >= length){
			
			length = length + 4;
			Integer[] newArray = new Integer[length];
			
			for(int i=0; i<objs.length; i++){
				
				newArray[i] = objs[i];
			}
			
			objs = newArray;
		}
		
		objs[rear] = item;
		rear++;
	}
	
	public int size(){
		
		return rear;
	}
	
	public Integer dequeue(){
		
		Integer target = objs[0];
		
		for(int i=1; i<rear; i++){
			
			objs[i-1] = objs[i];
		}
		
		objs[rear-1] = null;
		rear--;
		
		return target;
	}
	
	public static void main(String[] args) {
		
		ResizingArrayQuenueOfStrings resizingArrayQuenueOfStrings = new ResizingArrayQuenueOfStrings();
		resizingArrayQuenueOfStrings.enqueue(1);
		resizingArrayQuenueOfStrings.enqueue(2);
		resizingArrayQuenueOfStrings.enqueue(3);
		resizingArrayQuenueOfStrings.enqueue(4);
		resizingArrayQuenueOfStrings.enqueue(5);
		
		while(!resizingArrayQuenueOfStrings.isEmpty()){
			
			System.out.println(resizingArrayQuenueOfStrings.dequeue());
		}
	}
}
