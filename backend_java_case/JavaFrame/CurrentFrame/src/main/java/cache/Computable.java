package cache;

/**
 * 输入类型为A,输出类型为V
 * @author Administrator
 *
 * @param <A>
 * @param <V>
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}

