package 单例模式;

public class TestMain {
	public static void a(){
		ChocolateBoiler boile = ChocolateBoiler.getInstance();
		System.out.println(boile);
	}
	
	public static void main(String[] args) {
		a();
		ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		System.out.println(boiler);
		
	}

}
