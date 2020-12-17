package �㷨���İ�.ch01.����;

import java.util.Arrays;

/**
 * 二分查找
 * @author yangzuliang
 *
 */
public class BinarySearch {
	/**
	 * ���ֲ���
	 * ���ֲ����ֳ��۰���ң��ŵ��ǱȽϴ����٣������ٶȿ죬ƽ�����ܺã�
	 * ��ȱ����Ҫ������Ϊ������Ҳ���ɾ�����ѡ���ˣ��۰���ҷ��������ڲ������䶯������Ƶ���������б�
	 * ���ȣ��������Ԫ���ǰ��������У������м�λ�ü�¼�Ĺؼ�������ҹؼ��ֱȽϣ����������ȣ�
	 * ����ҳɹ������������м�λ�ü�¼����ֳ�ǰ���������ӱ�����м�λ�ü�¼�Ĺؼ��ִ��ڲ��ҹؼ��֣�
	 * ���һ������ǰһ�ӱ������һ�����Һ�һ�ӱ��ظ����Ϲ��̣�ֱ���ҵ����������ļ�¼��ʹ���ҳɹ�����ֱ���ӱ�����Ϊֹ����ʱ���Ҳ��ɹ�
	 * @param key
	 * @param a
	 * @return
	 */
	public static int rank(int key, int[] a){
		//�����±�
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			int mid = lo + (hi -lo) / 2;
			if(key < a[mid]){
				hi = mid - 1;
			}else if( key > a[mid]){
				lo = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	 public static void main(String[] args) {
		int[] whitelist = {6,5,3,7,4,9};
		Arrays.sort(whitelist);
		int target = rank(3, whitelist);
		System.out.println(whitelist[target]);
	}

}
