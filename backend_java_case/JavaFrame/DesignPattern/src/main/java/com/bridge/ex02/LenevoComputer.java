package com.bridge.ex02;

public class LenevoComputer extends AbstractComputer{
	public LenevoComputer(CpuAbility cpuAbility) {
		super(cpuAbility);
	}
	@Override
	public void checkPcAbility() {
		System.out.println("联想" + super.cpuAbility.abilityCpu());
	}
}
