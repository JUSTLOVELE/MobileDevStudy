package �㷨���������.��̬�滮;

/**
 * �����������
 *  �Ӵ�:�Ӵ��Ǵ���һ�������Ĳ���,
 *  ������:�������ǲ��ı��е�˳��,����������ȥ�������Ԫ�ض�����µ�����
 * Ҳ����˵,�Ӵ����ַ���λ�ñ�����������,����������Բ�������
 * ��X[1...m], Y[1...n]
 * ����: c[i][j] = |LCS(X[1...i], Y[1...j])| ; c[i][j]��ʾ(X[1...i], Y[1...j]) �����������
 * ��Ȼc[m][n]���ǽ��
 * �ݹ�ʽ:
 *   i=0��j=0 : c[i][j] = 0;
 *   i,j>0��xi = yj : c[i-1][j-1]+1 //�������ͬ�ľ�+1
 *   i,j>0��xi != yj : max(c[i,j-1], c[i-1],j) //ֵ���Ȳ���һ�������Ǹ�ֵ�Ϳ���
 * @author Administrator
 *
 */
public class Ex_3_LCS {

	public static void main(String[] args) {
		char[] X = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
		char[] Y = {'B', 'D', 'C', 'A', 'B', 'A'};
	//	char[] X = {'B', 'C', 'D', 'A', 'F', 'G', 'K'};
	//	char[] Y = {'A', 'C', 'E', 'F', 'N', 'B', 'K'};
		memo(X, Y);
	}
	
	/**
	 * �Զ����´�����
	 * @param X
	 * @param Y
	 */
	public static void memo(char[] X, char[] Y){
		
		int m = X.length;
		int n = Y.length;
		int[][] c = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				c[i][j] = -1;
			}
		}
		
		for(int i=0; i<=m; i++){
			c[i][0] = 0;
		}
		
		for(int j=0; j<=n; j++){
			c[0][j] = 0;
		}
		
		for(int i=1; i<=m; i++){
			
			for(int j=1; j<=n; j++){
				
				if(c[i][j] == -1){
					
					if(X[i-1] == Y[j-1]){
						c[i][j] = c[i-1][j-1] + 1;
					}else{
						int a = c[i-1][j];
						int b = c[i][j-1];
						
						if(a < b){
							c[i][j] = b;
						}else{
							c[i][j] = a;
						}
					}
				}
			}
		}
		
		System.out.println(c[m][n]);
	}
}
