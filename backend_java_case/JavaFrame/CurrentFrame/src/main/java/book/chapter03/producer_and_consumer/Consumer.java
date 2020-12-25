package book.chapter03.producer_and_consumer;

/**
 * @author yangzl 2020.12.25
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class Consumer {

    private String lock;

    public Consumer(String lock) {
        super();
        this.lock = lock;
    }

    public void getValue() {

        try{

            synchronized (lock) {

                if(ValueObject.value.equals("")) {
                    lock.wait();
                }

                System.out.println("get的值是" + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
