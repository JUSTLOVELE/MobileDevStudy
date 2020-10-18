package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用HashMap来保存之前计算的结果
 * @author Administrator
 *
 * @param <A>
 * @param <V>
 */
public class MemoryCache <A, V> implements Computable<A, V> {


    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public MemoryCache(Computable<A, V> c){

        this.c = c;
    }

    /**
     * 检查需要的结果是否已经在缓存中,如果存在则返回之前计算的值,否则把计算结果缓存在HashMap中,然后再返回
     * HashMap不是线程安全的,因此要确保两个线程不会同时访问HashMap,这里使用同步策略,但会带来一个问题,每次只有
     * 一个线程能执行compute,如果另一个线程正在计算结果那么调用compute的线程可能会被阻塞很长时间
     */
    @Override
    public synchronized V compute(A arg) throws InterruptedException {

        V result = cache.get(arg);

        if(result == null){

            result = c.compute(arg);
            cache.put(arg, result);
        }

        return result;
    }
}
