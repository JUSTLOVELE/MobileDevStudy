package book.chapter03.producer_and_consumer;

/**
 * @author yangzl 2020.12.25
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class Run {

    public static void main(String[] args) {

        String lock = new String("");
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        ThreadP p = new ThreadP(producer);
        ThreadC c = new ThreadC(consumer);
        p.start();
        c.start();
    }
}
