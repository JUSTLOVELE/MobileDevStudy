package �㷨����.ch08.����ʱ������;

import java.util.Arrays;

import �㷨����.BaseService;

/**
 * ��������
 *  ����һ�����λ��3λ�����ݽ�������,�ȱȽϸ�λ,�ٱȽ�ʮλ,���Ƚϰ�λ
 *  ��ÿλ���ֶ���0��k-1������(����������k�����ܵ�ȡֵ),��k��ֵ��̫���ʱ��,��������ʹһ���õ�ѡ��,
 *����n��dλ����˵,ÿһ�������ʱO(n+k),����d��,��˻����������ʱ��ΪO(d(n+k))
 *��dΪ������k=O(n)ʱ,��������������Ե�ʱ�����,��һ��������,���ǿ������ľ�����ν�ÿ���ؼ��ַֽ�
 *Ϊ����λ
 * ��ô���������Ƿ�ȿ��Ÿ�����?
 *  ������ԭַ����,������������Ȼ����,��˵����������Ƚϱ���ʱ,���ǿ��ܻ�������ڿ�������������ԭַ����
 * @author Administrator
 * 
 */
public class MultiKeyRadixSort extends BaseService {

	public static void main(String[] args) {
		int[] data = {3,2,3,2,5,333,45566,2345678,78,990,12,432,56}; 
		print(data);
		radixSort(data, 10, 7);
		print(data);
	}

	/**
	 * 
	 * @param array
	 * @param radix
	 *            :����
	 * @param distance
	 *            :��������Ԫ�ص�λ��
	 */
	public static void radixSort(int[] array, int radix, int distance) {

		int length = array.length;
		int[] temp = new int[length];// �����ݴ�Ԫ��
		int[] count = new int[radix];// ���ڻ�������
		int divide = 1;

		for (int i = 0; i < distance; i++) {

			System.arraycopy(array, 0, temp, 0, length);
			Arrays.fill(count, 0);

			for (int j = 0; j < length; j++) {
				//��ͬλ��������,Ȼ�����
				int tempKey = (temp[j] / divide) % radix;
				count[tempKey]++;
			}

			for (int j = 1; j < radix; j++) {
				count[j] = count[j] + count[j - 1];
			}

			for (int j = length - 1; j >= 0; j--) {
				int tempKey = (temp[j] / divide) % radix;
				count[tempKey]--;
				array[count[tempKey]] = temp[j];
			}

			divide = divide * radix;
		}
	}
}
