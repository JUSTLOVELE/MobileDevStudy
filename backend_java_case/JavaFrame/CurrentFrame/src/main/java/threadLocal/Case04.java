package threadLocal;

import java.util.Date;

/**
 * @author yangzl 2020.01.14
 * @version 1.00.00
 * @Description:
 * @history:
 */

class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue +"in child thread ~!";
    }
}

class ExtThread extends Thread {
    @Override
    public void run() {

        try {

            for(int i=0; i<10; i++) {
                System.out.println("in ExtThread : " + Tools.i1.get());
                Thread.sleep(100);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}



public class Case04 {

    public static void main(String[] args) {

        try {

            for(int i=0; i<10; i++) {
                System.out.println("in main : " + Tools.i1.get());
                Thread.sleep(100);
            }

            Thread.sleep(5000);
            ExtThread a = new ExtThread();
            a.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
