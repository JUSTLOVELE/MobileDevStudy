package lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranLock {

    @Test
    public void test() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
