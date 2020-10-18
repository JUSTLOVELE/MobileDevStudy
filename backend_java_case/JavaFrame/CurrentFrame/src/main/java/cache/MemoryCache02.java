package cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryCache02 <A, V> implements Computable<A, V> {
    //这里使用ConcurrentHashMap来代替HashMap来改进并发行为
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public MemoryCache02(Computable<A, V> c){
        this.c = c;
    }
    /**
     * ConcurrentHashMap是线程安全的,因此在访问底层Map时就不需要进行同步,因而避免了在Memoizer1中的串行性问题
     * Memoizer2比Memoizer1有更发的并发行为:多线程可以并发的使用它,但它在作为缓存时仍然存在一些不足,当两个线程同时调用compute时存在一个漏洞
     * 可能会导致计算得到相同的值,在使用memoization的情况下,这只会带来低效,因为缓存的作用是避免相同的数据被计算多次,但对于通用的缓存机制来说,这种
     * 情况将会更糟糕,对于只提供单次初始化的对象缓存来说,这个漏洞就会带来安全风险
     * Memoizer2的问题在于,如果某个线程启动了一个开销很大的计算而其他线程并不知道这个计算正在进行,那么可能会重复这个计算
     */
    @Override
    public V compute(A arg) throws InterruptedException {

        V result = cache.get(arg);

        if(result == null){

            result = c.compute(arg);
            cache.put(arg, result);
        }

        return result;
    }

}
