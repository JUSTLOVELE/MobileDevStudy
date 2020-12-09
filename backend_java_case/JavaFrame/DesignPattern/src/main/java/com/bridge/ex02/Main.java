package com.bridge.ex02;

/**
 * 通过对象组合的方式,桥接模式把两个角色之间的继承关系改为耦合关系,从而使这两者可以从容自若的
 * 各自独立变化
 * @author yangzuliang
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		CpuAbility cpuAbility = new InterCpu();
		AbstractComputer abstractComputer = new LenevoComputer(cpuAbility);
		abstractComputer.checkPcAbility();
	}

}
