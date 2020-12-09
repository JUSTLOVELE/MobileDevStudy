package 访问者模式;

/**
 * 具体角色
 * @author yangzuliang
 *
 */
public class GladiolusConcreteElement implements FlowerElement {

	@Override
	public void accept(final Visitor visitor) {
		
		visitor.visit(this);
	}

}
