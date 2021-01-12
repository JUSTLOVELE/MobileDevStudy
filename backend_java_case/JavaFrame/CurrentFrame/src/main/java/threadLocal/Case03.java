package threadLocal;

/**
 * @author yangzl 2020.01.12
 * @version 1.00.00
 * @Description:解决get返回Null
 * @history:
 */
public class Case03 extends ThreadLocal{

    @Override
    protected Object initialValue() {
        return "default";
    }
}
