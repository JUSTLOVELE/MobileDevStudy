package fork;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/**
 *
 * left.fork();
 * left.join();是关键
 *   fork/join范型所实现的挂起,使得所有任务可以交由少量的线程执行,
 * 如下列代码会创建几百万个任务,很容易交由少量一些线程执行
 *   使用ThreadPoolExecutor运行类似算法则需要200多万个线程,因
 *为每个线程必须等待其子任务完成,而且那些子任务只有在池中有可用线程时才能
 *完成,有了fork/join,我们可以实现用ThreadPoolExecutor无法实现
 *的算法
 *
 *ForkJoinPool还有一个额外的特性:它实现了工作窃取,这基本上就是一个实现细节了:
 *  这意味着池中的每个线程都有自己所创建任务的队列,线程会优先处理自己队列中的任务,
 *但如果这个队列已空,它会从其他线程的队列中窃取任务,其结果是,即使200W个任务中有
 *一个需要很长的执行时间,ForkJoinPool中的其他线程也可以完成其余的随便什么任务,
 *ThreadPoolExecutor则不会这样,如果一个任务需要很长时间,其他线程并不能处理
 *额外的工作
 *
 *
 * @author Administrator
 *
 */
public class ForkJoinTest {

    private double[] d;

    private class ForkJoinTask extends RecursiveTask<Integer>{

        private int first;
        private int last;

        private ForkJoinTask(int first, int last){

            this.first = first;
            this.last = last;
        }

        @Override
        protected Integer compute() {

            int subCount;

            if(last - first < 10){

                subCount = 0;

                for(int i=first; i<=last; i++){

                    if(d[i] < 0.5){
                        subCount++;
                    }
                }

            }else{

                int mid = (first + last) >>> 1;
                ForkJoinTask left = new ForkJoinTask(first, mid);
                left.fork();
                ForkJoinTask right = new ForkJoinTask(mid + 1, last);
                right.fork();
                subCount = left.join();
                subCount += right.join();
            }

            return subCount;
        }
    }

    public static void main(String[] args) {

        ForkJoinTest ft = new ForkJoinTest();
        ft.createArrayOfRandomDoubles();
        ForkJoinTask f = ft.new ForkJoinTask(0, 49);
        int n = new ForkJoinPool().invoke(f);
        System.out.println(n);
    }

    public void createArrayOfRandomDoubles(){

        d = new double[50];
        Random r = new Random();

        for(int i=0; i<d.length; i++){
            d[i] = r.nextDouble();
        }
    }
}
