package cache;

import java.util.concurrent.*;

public class MemoryCache04 <A, V> implements Computable<A, V>  {


    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public MemoryCache04(Computable<A, V> c){
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {

        while(true){

            Future<V> f= cache.get(arg);
            if(f == null){
                Callable<V> eval = new Callable<V>() {

                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };

                FutureTask<V> ft = new FutureTask<V>(eval);
                f = cache.putIfAbsent(arg, ft);
                if(f == null){
                    f = ft;
                    ft.run();
                }
            }

            try {
                return f.get();
            } catch (CancellationException e){
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
