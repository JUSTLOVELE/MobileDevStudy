package base;


import net.jcip.annotations.NotThreadSafe;

/**
 * 不是线程安全,因为Get和set都是在没有同步的情况下访问value
 * 把set和get都用synchronized修饰就能实现安全类
 * @author Administrator
 *
 */
@NotThreadSafe
public class MultableInteger {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
