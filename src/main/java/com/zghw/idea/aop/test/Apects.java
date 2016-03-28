package com.zghw.idea.aop.test;

public class Apects {
	public void before_2_method1(){
		System.out.println("before_2_method1被调用");
	}
	/**
	 * 简单描述
	 * before 代表方法前 
	 * 1 代表第一个before 顺序
	 * method1代表是目标对象方法名
	 */
	public void before_1_method1(){
		System.out.println("before_1_method1被调用");
	}
	
	public void before_3_method1(){
		System.out.println("before_3_method1被调用");
	}
	
	public void after_1_method1(){
		System.out.println("after_1_method1被调用");
	}
	public void after_2_method1(){
		System.out.println("after_2_method1被调用");
	}
}
