package com;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 计算数组中小于0.5的元素的个数
 */
public class ThreadPoolTest {

    private double[] d;

    private class ThreadPoolExecutorTask implements Callable<Integer>{

        private int first;
        private int last;

        public ThreadPoolExecutorTask(int first, int last){

            this.first = first;
            this.last = last;
        }

        @Override
        public Integer call() throws Exception {

            System.out.println("call");
            int subCount = 0;

            for(int i=first; i<= last; i++){

                if(d[i] < 0.5){
                    subCount++;
                }
            }

            return subCount;
        }

    }

    public void createArrayOfRandomDoubles(){

        d = new double[50];
        Random r = new Random();

        for(int i=0; i<d.length; i++){
            d[i] = r.nextDouble();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        threadPoolTest.createArrayOfRandomDoubles();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, Long.MAX_VALUE, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        Future[] f = new Future[4];
        int size = threadPoolTest.d.length/4;

        for(int i=0; i<=3; i++){
            f[i] = threadPoolExecutor.submit(threadPoolTest.new ThreadPoolExecutorTask(i*size, (i+1)*size -1));
        }
        //f[3] = threadPoolExecutor.submit(threadPoolTest.new ThreadPoolExecutorTask(3*size, threadPoolTest.d.length-1));
        int n = 0;

        for(int i=0; i<4; i++){
            n += (Integer)f[i].get();
        }

        System.out.println(n);
    }
}
