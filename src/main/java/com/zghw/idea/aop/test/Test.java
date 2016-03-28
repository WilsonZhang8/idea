package com.zghw.idea.aop.test;

import com.zghw.idea.aop.BuilderAdvisor;

public class Test {
	public static void main(String args[]){
		MyTargetIfc myi =new MyTarget();
		Apects apects = new Apects();
		Object obj=BuilderAdvisor.proxy(myi, apects);
		MyTargetIfc proxy=(MyTargetIfc)obj;
		proxy.method1();
		int a=proxy.method2(1,2);
		System.out.println(a);
	}
}
