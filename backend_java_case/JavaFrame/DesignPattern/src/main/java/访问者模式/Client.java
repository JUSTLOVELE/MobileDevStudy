package 访问者模式;

public class Client {

	public static void main(final String[] args) {
		final ObjectStructure os = new ObjectStructure();
		os.addElement(new GladiolusConcreteElement());
		os.addElement(new ChrysanthemumConreteElement());

		final GladiolusVisitor gVisitor = new GladiolusVisitor();
		final ChrysanthemumVisitor chVisitor = new ChrysanthemumVisitor();

		os.accept(gVisitor);
		os.accept(chVisitor);

	}
}
