package com.bridge.ex01;

import com.bridge.ex01.Brand;

public class XiaoMi implements Brand {

	@Override
	public void open() {
		System.out.println("小米");
	}

	@Override
	public void close() {
		System.out.println("小米");
	}

	@Override
	public void call() {
		System.out.println("小米");
	}

}
