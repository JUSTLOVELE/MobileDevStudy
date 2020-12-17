package �㷨����;


/**
 * ��������:��һ���Ѿ�������������У�Ҫ��������Ѿ��źõ����������в���һ��������Ҫ�����������������Ȼ����
 * @author yangzuliang
 *
 */
public class InsertIntoSort {
	
	/**
	 * ����һ�����飺[5,6,1,8,4,9,3,2]
	 * @param array
	 * @return
	 */
	public Integer[] insertSort(Integer[] array){
		if(array != null){
			
			if(array.length > 1){
				//�ж������ʵ�ʳ���
				Integer factLength = examineLength(array);
				if(factLength !=null && factLength > 1){
					//�����±�ֻ�ܵ�����-1��λ���������Ϊ<= �ᱨ����Խ��
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
	 * �ж������ʵ�ʳ���
	 */
	public Integer examineLength(Object obj){
		//�������Ĳ�����׳��Ӧ��Ҫ�½�һ������Ȼ��Ϊnull��ֵ����ȥ���������Ա����ֵ���������
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
