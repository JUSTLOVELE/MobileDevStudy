package �㷨���İ�.ch01.��ϰ;

/**
 * P108 ʹ�ö�������ʵ�ֶ��еĳ���,Ȼ����չʵ��ʹ�õ�������Ĵ�Сͻ�ƴ�С������
 * @author yangzuliang
 *
 */
public class ResizingArrayQuenueOfStrings {
    /**��ͷ**/
	private int front = 0; 
    /**��β**/
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
