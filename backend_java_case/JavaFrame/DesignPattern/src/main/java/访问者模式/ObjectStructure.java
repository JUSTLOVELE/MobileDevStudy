package 访问者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象构造角色:能美剧元素提供一个高层的接口以允许该访问者访问它的元素
 * @author yangzuliang
 *
 */
public class ObjectStructure {

	private final List<FlowerElement> elements = new ArrayList<FlowerElement>();

	public void addElement(final FlowerElement e) {

		elements.add(e);
	}

	public void removeElement(final FlowerElement e) {
		elements.remove(e);
	}

	public void accept(final Visitor visitor) {
		for (final FlowerElement e : elements) {
			e.accept(visitor);
		}
	}
}
