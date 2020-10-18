package cache;

import java.util.Map;
import java.util.concurrent.*;

public class MemoryCache03 <A, V> implements Computable<A, V>  {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public MemoryCache03(Computable<A, V> c){
        this.c = c;
    }
    /**
     * Memoizer3首先检查某个相应的计算是否已经开始(Memoizer2与之相反,它首先判断某个计算是否已经完成)
     * 如果还没有启动那么就创建一个FutureTask,并注册到Map中,然后启动计算,如果已经启动,那么等待现有计算的结果
     * 结果可能很快会得到,也可能还在运算过程中,但这对于Future.get的调用者来说是透明的
     * Memoizer3的实现几乎是完美的:表现出了非常好的并发性(基本上源于ConcurrentHashMap高效并发),如果结果计算出来,那么立即返回
     * 如果其他线程正在计算该结果,那么新到的线程将一直等待这个结果被计算出来,它只有一个缺陷,即仍然存在两个线程计算出相同值的漏洞,这个漏洞的发生概率远小于Memoizer2发生的概率,
     * 但由于compute方法中的if代码块仍然是非原子的先检查再执行操作因此两个线程仍然有可能再同一时间内调用compute来计算相同的值,即二者都没有在缓存中找到期望的值,因此都开始计算
     * Memoizer3中存在这个问题的原因是复合操作时在底层的Map对象上执行的,而这个对象无法通过加锁来确保原子性
     */
    @Override
    public V compute(final A arg) throws InterruptedException {

        Future<V> f= cache.get(arg);
        if(f == null){
            Callable<V> eval = new Callable<V>() {

                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };

            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run();
        }

        try {
            return f.get();
        } catch (ExecutionException e) {

            throw new RuntimeException(e);
        }
    }
}
