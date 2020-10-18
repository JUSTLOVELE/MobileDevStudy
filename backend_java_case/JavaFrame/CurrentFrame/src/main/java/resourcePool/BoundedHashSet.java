package resourcePool;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Semaphore可以用于实现资源池,例如数据库连接,我们可以构造一个固定长度的资源池,当池为空时,请求资源将会失败,但你真正希望看到的行为是阻塞
 * 而不是失败,并且当吃非空时解除阻塞
 * @author Administrator
 *
 * @param <T>
 */
public class BoundedHashSet<T> {

    private final Set<T> set;

    private final Semaphore sem;

    public BoundedHashSet(int bound){
        this.set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {

        sem.acquire();
        boolean wasAdded = false;

        try {

            wasAdded = set.add(o);
            return wasAdded;

        } finally {

            if(!wasAdded){
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {

        boolean wasRemoved = set.remove(o);

        if(wasRemoved){
            sem.release();
        }

        return wasRemoved;
    }
}