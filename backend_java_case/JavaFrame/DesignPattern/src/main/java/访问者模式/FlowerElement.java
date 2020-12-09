package 访问者模式;

/**
 * 元素角色
 * @author yangzuliang
 *
 */
public interface FlowerElement {

	public void accept(Visitor visitor);
}
