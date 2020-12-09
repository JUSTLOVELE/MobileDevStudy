package 原型模式;

public class Prototype implements Cloneable{

	public Prototype clone(){
		
		Prototype prototype = null;
		
		try {
			prototype = (Prototype) super.clone();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return prototype;
	}
}
