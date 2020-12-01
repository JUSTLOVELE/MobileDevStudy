package book.chapter01;

/**
 * @author yangzl 2020.12.01
 * @version 1.00.00
 * @Description:
 * @history:
 */

class YieldMethod extends Thread {

    @Override
    public void run() {

        long beginTime = System.currentTimeMillis();
        int count = 0;

        for(int i=0; i<50000000; i++) {
            //放弃当前cpu资源,让给其他任务去占用CPU执行时间。但放弃的时间不确定，有可能刚放弃了又获得了CPU时间
            Thread.yield();
            count = count + (i + 1);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("用时:" + (endTime - beginTime) + "毫秒!");
    }
}

public class ThreadYieldMethod {

    public static void main(String[] args) {
        YieldMethod y = new YieldMethod();
        y.start();
    }
}
