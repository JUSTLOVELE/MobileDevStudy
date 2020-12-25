package book.chapter03.producer_and_consumer;

/**
 * @author yangzl 2020.12.25
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class ThreadP extends Thread {

    private Producer p;

    public ThreadP(Producer p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while(true) {
            p.setValue();
        }
    }
}
