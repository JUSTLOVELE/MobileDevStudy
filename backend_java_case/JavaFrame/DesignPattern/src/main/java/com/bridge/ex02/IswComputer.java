package com.bridge.ex02;

public class IswComputer extends AbstractComputer{
	public IswComputer(CpuAbility cpuAbility) {
		super(cpuAbility);
	}
	@Override
	public void checkPcAbility() {
		System.out.println("ISW : " + super.cpuAbility.abilityCpu());
	}
}
