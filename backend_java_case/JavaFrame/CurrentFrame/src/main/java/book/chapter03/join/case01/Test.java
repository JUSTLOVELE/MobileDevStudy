package book.chapter03.join.case01;


public class Test {

	/**
	 * 主线程创建并启动子线程,如果子线程中要进行大量的耗时运算,主线程往往将早于子线程结束之前结束
	 * 这时,如果主线程想等待子线程执行完成之后再结束,就要使用join方法了
	 * join具有使线程排队运行的作用,有点类型同步的效果,join在内部使用wait()方法进行等待
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyThread threadTest = new MyThread();
			threadTest.start();
			threadTest.join();

			System.out.println("等待完成OK");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
