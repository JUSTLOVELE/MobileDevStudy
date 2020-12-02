package com.builder.a;

/**
 * 建造者模式
 * 创建者模式又叫建造者模式，是将一个复杂的对象的构建与它的表示分离，使
 * 得同样的构建过程可以创建不同的表示。创建者模式隐藏了复杂对象的创建过程，
 * 它把复杂对象的创建过程加以抽象，通过子类继承或者重载的方式，动态的创建具有复合属性的对象。
 *

 *
 * @author Administrator
 *
 */
public abstract class AbstractHouse {
	//打地基
	public abstract void buildBasic();
	//砌墙
	public abstract void buildWalls();
	//封顶
	public abstract void roofed();
	
	public void build() {
		
		buildBasic();
		buildWalls();
		roofed();
	}
}
