package base;


import java.math.BigInteger;
import java.util.Arrays;

import net.jcip.annotations.Immutable;

/**
 * 对数值及其因数分解结果进行缓存的不可变容器类
 * @author Administrator
 *
 */
@Immutable
public class OneValueCache {

    private final BigInteger lastNumber;

    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] factors){

        lastNumber = i;

        lastFactors = Arrays.copyOf(factors, factors.length);
    }

    /**
     * 通过lastNumber来获取当前线程的lastFactors
     * 因为lastNumber是不可变对象只能被赋值一次,所以他被当做类似key的作用
     * @param i
     * @return
     */
    public BigInteger[] getFactors(BigInteger i){

        if(lastNumber == null || !lastNumber.equals(i)){

            return null;
        }else{

            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }

}
