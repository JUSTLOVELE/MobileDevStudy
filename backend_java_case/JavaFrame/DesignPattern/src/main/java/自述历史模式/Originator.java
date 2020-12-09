package 自述历史模式;

/**
 * 发起人角色同时还兼任负责人角色，也就是说它自己负责保持自己的备忘录对象
 * @author yangzuliang
 *
 */
public class Originator {

    public String state;
    /**
     * 改变状态
     */
    public void changeState(String state){
        this.state = state;
        System.out.println("状态改变为：" + state);
    }
    /**
     * 工厂方法，返还一个新的备忘录对象
     */
    public Memento createMemento(){
        return new Memento(this);
    }
    /**
     * 将发起人恢复到备忘录对象所记录的状态上
     */
    public void restoreMemento(MementoIF memento){
        Memento m = (Memento)memento;
        changeState(m.state);
    }
    
    private class Memento implements MementoIF{
        
        private String state;
        /**
         * 构造方法
         */
        private Memento(Originator o){
            this.state = o.state;
        }
        private String getState() {
            return state;
        }
        
    }
}