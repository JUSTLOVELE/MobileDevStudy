package 算法导论;


/**
 * 插入排序:有一个已经有序的数据序列，要求在这个已经排好的数据序列中插入一个数，但要求插入后此数据序列仍然有序
 * @author yangzuliang
 *
 */
public class InsertIntoSort {
	
	/**
	 * 输入一堆数组：[5,6,1,8,4,9,3,2]
	 * @param array
	 * @return
	 */
	public Integer[] insertSort(Integer[] array){
		if(array != null){
			
			if(array.length > 1){
				//判断数组的实际长度
				Integer factLength = examineLength(array);
				if(factLength !=null && factLength > 1){
					//数组下表只能到长度-1的位置如果设置为<= 会报数组越界
					for(int i=1; i<factLength; i++){
						int k= i - 1;
						while(k>=0){
							if(array[k] > array[k+1]){
								int temp = array[k+1];
								array[k+1] = array[k];
								array[k] = temp;
							}
							k--;
						}
					}
					return array;
				}
				else if(factLength == 1){
					return array;
				}
			}
			else if(array.length == 1){
				return array ;
			}
		}
		
		
		return null;
	}
	
	/**
	 * 判断数组的实际长度
	 */
	public Integer examineLength(Object obj){
		//这里做的不够健壮，应该要新建一个数组然后不为null的值付过去，这样可以避免空值的排序出现
		if(obj instanceof Integer[]){
			Integer[] array = (Integer[]) obj;
			int num = 0;
			for(Integer data : array){
				if(data != null){
					num ++;
				}
			}
			return num;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		InsertIntoSort insertIntoSort = new InsertIntoSort();
		Integer[] array = {5,6,1,8,4,9,3,2};
		array = insertIntoSort.insertSort(array);
		for(Integer num : array){
			System.out.println(num);
		}
	}
}
