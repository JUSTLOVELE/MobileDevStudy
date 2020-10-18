package cache;


import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String, BigInteger>{

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        //大量计算
        return new BigInteger(arg);
    }

}
