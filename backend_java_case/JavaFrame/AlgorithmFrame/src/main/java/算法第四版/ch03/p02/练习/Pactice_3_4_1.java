package �㷨���İ�.ch03.p02.��ϰ;

import �㷨���İ�.ch03.p02.ɢ�б�.LinearProbingHashST;

/**
 * ����E A S Y Q U T I O N���β���һ�ų�ʼΪ���Һ���M=5������Ļ�����������ɢ�б���
 * ʹ��ɢ�к���11k%M����k����ĸɢ�е�ĳ������������
 * @author yangzuliang
 *
 */
public class Pactice_3_4_1 {

	public static void main(String[] args) {
		
		LinearProbingHashST<String, String> l = new LinearProbingHashST<String, String>(5);
		l.put("E", "E");
		l.put("A", "A");
		l.put("S", "S");
		l.put("Y", "Y");
		l.put("Q", "Q");
		l.put("U", "U");
		l.put("T", "T");
		l.put("I", "I");
		l.put("O", "O");
		l.put("N", "N");
		
		System.out.println(l.get("E"));
	}
}
