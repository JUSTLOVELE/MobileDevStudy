package signal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @author yangzl 2020.07.20
 * @history:
 *
 *  *  可以使用Semaphore将任何一种容器变成有界阻塞容器,Semaphore中管理着一组虚拟的许可,许可的初始化数量可
 *  * 通过构造函数来指定 ,在执行操作时可以首先获得许可(只要还有剩余的许可),并在使用以后释放许可,如果没有许可,那么
 *  * acquire将阻塞知道有许可(或者直到被中断或者操作超时).release方法将返回一个许可给信号量
 *  *  计数信号量的一种简化形式是二值信号量,即初始值为1的Semaphore,二值信号量可以用做互斥体,并具备不可重入的
 *  * 加锁语义:谁拥有这个唯一的许可,谁就拥有了互斥锁
 *  *
 *  *   计数信号量用来控制同时访问某个特定资源的操作数量,或者同时执行某个指定操作的数量,
 *  * 计数信号量还可以用来实现某种资源池,或者对容器施加边界
 *
 *
 */
public class BoundHashSet<T> {

    private final Set<T> set;

    private final Semaphore sem;

    public BoundHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    public boolean remove(Object o) {

        boolean wasRemoved = set.remove(o);

        if(wasRemoved)
            sem.release();

        return wasRemoved;
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded =false;

        try{
            wasAdded = set.add(o);
            return wasAdded;
        }finally {
            if(!wasAdded)
                sem.release();
        }
    }

}
