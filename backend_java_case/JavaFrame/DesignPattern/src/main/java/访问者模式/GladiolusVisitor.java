package 访问者模式;

public class GladiolusVisitor implements Visitor {

	@Override
	public void visit(GladiolusConcreteElement gladious) {
		
		System.out.println(this.getClass().getSimpleName() + "access" + gladious.getClass().getSimpleName());
	}

	@Override
	public void visit(ChrysanthemumConreteElement chrysanthemum) {

		System.out.println(this.getClass().getSimpleName() + "access" + chrysanthemum.getClass().getSimpleName());
	}

}
