package 访问者模式;

/**
 * 访问者角色:为该对象结构中具体 元素角色声明一个访问操作接口
 * @author yangzuliang
 *
 */
public interface Visitor {
	
	public void visit(GladiolusConcreteElement gladious);
	
	public void visit(ChrysanthemumConreteElement chrysanthemum);
}
