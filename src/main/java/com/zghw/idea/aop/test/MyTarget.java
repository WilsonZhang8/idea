package com.zghw.idea.aop.test;

public class MyTarget implements MyTargetIfc {

	public void method1() {
		System.out.println("method1");
	}

	public int method2(int a, int b) {
		System.out.println("method2");
		return a+b;
	}

	public int method3(int c) {
		System.out.println("method3");
		return method2(1,2)+c;
	}

}
