package �㷨���İ�.ch02.����;

import java.util.Random;

public class Stdrandom {
	//���������
	private static Random random;
	//���ڲ��������������
	private static long seed;
	// ��̬��ʼ������
	static {
	//�������������
	seed = System.currentTimeMillis();
	random = new Random(seed);
	}
	private Stdrandom() { }
	/***********************************************************
	* ���������������
	***********************************************************/
	/**
	* ��ȡ����ʵ����α�������������
	*/
	public static void setseed(long s) {
	seed = s;
	random = new Random(seed);
	}
	/**
	* ��ȡ����ʵ���ṩ��α�������������
	*/
	public static long getseed() {
	return seed;
	}
	/**
	* ����һ������ķ�Χ��[0,1)֮���double���͵���
	*/
	public static double uniform() {
	return random.nextDouble();
	}
	/**
	* ����һ������ķ�Χ��[0,n)֮���int���͵���
	*/
	public static int uniform(int n) {
	return random.nextInt(n);
	}
	/**
	* ����һ����Χ�� [0, 1)��ʵ��
	*/
	public static double random() {
	return uniform();
	}
	/**
	* ����һ����Χ�� [a, b)��int����ֵ
	*/
	public static int uniform(int a, int b) {
	return a + uniform(b - a);
	}
	/**
	* ����һ����Χ�� [a, b)��ʵ��
	*/
	public static double uniform(double a, double b) {
	return a + uniform() * (b-a);
	}
	/**
	* ����һ�����booleanֵ,��p��ʾ�˲���ֵΪ��ĸ���
	* @param p 0~1 ֮���doubleֵ,��ʾ����boolean��ֵ�Ŀ�����
	*/
	public static boolean bernoulli(double p) {
	return uniform() < p;
	}
	/**
	* ����һ�����booleanֵ,�˲���ֵΪ��ĸ���Ϊ0.5
	*/
	public static boolean bernoulli() {
	return bernoulli(0.5);
	}
	/***********************************************************
	* ���������ض����ʷֲ���ʵ��
	***********************************************************/
	/**
	* ����һ�������׼��̬�ֲ���ʵ��
	*/
	public static double gaussian() {
	double r, x, y;
	do {
	x = uniform(-1.0, 1.0);
	y = uniform(-1.0, 1.0);
	r = x*x + y*y;
	} while (r >= 1 || r == 0);
	return x * Math.sqrt(-2 * Math.log(r) / r);
	}
	/**
	* ����һ������ƽ��ֵΪmean,��׼��Ϊstddev����̬�ֲ���ʵ��
	* @param mean ��̬�ֲ���ƽ��ֵ
	* @param stddev ��̫�ֲ��ı�׼��
	*/
	public static double gaussian(double mean, double stddev) {
	return mean + stddev * gaussian();
	}
	/**
	* ����һ�����㼸�ηֲ�������ֵ ƽ��ֵΪ1/p
	*/
	public static int geometric(double p) {
	// knuth
	return (int) Math.ceil(Math.log(uniform()) / Math.log(1.0 - p));
	}
	/**
	* ����ָ���Ĳ�������һ�����㲴�ɷֲ���ʵ��
	*/
	public static int poisson(double lambda) {
	// ʹ�� knuth ���㷨
	// �μ�
	int k = 0;
	double p = 1.0;
	double l = Math.exp(-lambda);
	do {
	k++;
	p *= uniform();
	} while (p >= l);
	return k-1;
	}
	/**
	* ����ָ���Ĳ���������һ�����������зֲ���ʵ��
	*/
	public static double pareto(double alpha) {
	return Math.pow(1 - uniform(), -1.0/alpha) - 1.0;
	}
	/**
	* ����һ����������ֲ���ʵ��
	*/
	public static double cauchy() {
	return Math.tan(Math.PI * (uniform() - 0.5));
	}
	/**
	* ����һ��������ɢ�ֲ���int���͵���
	* @param a �㷨�����������������Ҫʹ�ô���������ݣ�a[i]����i���ֵĸ���
	* ǰ������ a[i] �Ǹ��кͽӽ� 1.0
	 * @throws IllegalAccessException 
	*/
	public static int discrete(double[] a) throws IllegalAccessException {
	double epsilon = 1e-14;
	double sum = 0.0;
	for (int i = 0; i < a.length; i++) {
	if (a[i] < 0.0) throw new IllegalAccessException("����Ԫ��" + i + "Ϊ����:" + a[i]);
	sum = sum + a[i];
	}
	if (sum > 1.0 + epsilon || sum < 1.0 - epsilon)
	throw new IllegalAccessException("�������Ԫ��֮��Ϊ:" + sum);
	while (true) {
	double r = uniform();
	sum = 0.0;
	for (int i = 0; i < a.length; i++) {
	sum = sum + a[i];
	if (sum > r) return i;
	}
	}
	}
	/**
	* ����һ������ָ���ֲ���ʵ������ָ���ֲ�����Ϊlambda
	*/
	public static double exp(double lambda) {
	return -Math.log(1 - uniform()) / lambda;
	}
	/***********************************************************
	* �������
	***********************************************************/
	/**
	* �������ָ����object������
	* @param a �����ҵ�object������
	*/
	public static void shuffle(Object[] a) {
	int n = a.length;
	for (int i = 0; i < n; i++) {
	int r = i + uniform(n-i);
	Object temp = a[i];
	a[i] = a[r];
	a[r] = temp;
	}
	}
	/**
	* �������ָ����double������
	* @param a �����ҵ�double������
	*/
	public static void shuffle(double[] a) {
	int n = a.length;
	for (int i = 0; i < n; i++) {
	int r = i + uniform(n-i);
	double temp = a[i];
	a[i] = a[r];
	a[r] = temp;
	}
	}
	/**
	* �������ָ����int������
	* @param a �����ҵ�int������
	*/
	public static void shuffle(int[] a) {
	int n = a.length;
	for (int i = 0; i < n; i++) {
	int r = i + uniform(n-i);
	int temp = a[i];
	a[i] = a[r];
	a[r] = temp;
	}
	}
	/**
	* �������ָ��object����������ָ����Χ������
	*
	* @param a ָ��������
	* @param lo ��ʼλ��
	* @param hi ����λ��
	*/
	public static void shuffle(Object[] a, int lo, int hi) {
	if (lo < 0 || lo > hi || hi >= a.length) {
	throw new IndexOutOfBoundsException("���Ϸ��ı߽�");
	}
	for (int i = lo; i <= hi; i++) {
	int r = i + uniform(hi-i+1);
	Object temp = a[i];
	a[i] = a[r];
	a[r] = temp;
	}
	}
	/**
	* �������ָ��double����������ָ����Χ������
	*
	* @param a ָ��������
	* @param lo ��ʼλ��
	* @param hi ����λ��
	*/
	public static void shuffle(double[] a, int lo, int hi) {
	if (lo < 0 || lo > hi || hi >= a.length) {
	throw new IndexOutOfBoundsException("���Ϸ��ı߽�");
	}
	for (int i = lo; i <= hi; i++) {
	int r = i + uniform(hi-i+1);
	double temp = a[i];
	a[i] = a[r];
	a[r] = temp;
	}
	}
	/**
	* �������ָ��int����������ָ����Χ������
	*
	* @param a ָ��������
	* @param lo ��ʼλ��
	* @param hi ����λ��
	*/
	public static void shuffle(int[] a, int lo, int hi) {
	if (lo < 0 || lo > hi || hi >= a.length) {
	throw new IndexOutOfBoundsException("���Ϸ��ı߽�");
	}
	for (int i = lo; i <= hi; i++) {
	int r = i + uniform(hi-i+1);
	int temp = a[i];
	a[i] = a[r];
	a[r] = temp;
	}
	}
	}
