package book.chapter03.producer_and_consumer;

/**
 * @author yangzl 2020.12.25
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class Producer {

    private String lock;

    public Producer(String lock) {
        super();
        this.lock = lock;
    }

    public void setValue() {
        try{
            synchronized (lock) {

                if(!ValueObject.value.equals("")) {
                    lock.wait();
                }

                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set的值是" + value);
                ValueObject.value = value;
                lock.notify();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
