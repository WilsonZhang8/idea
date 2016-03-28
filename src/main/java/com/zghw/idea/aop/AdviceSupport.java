package com.zghw.idea.aop;

import java.util.LinkedList;
import java.util.List;

public class AdviceSupport {
	private Object target;
	private Class<?>[] interfaces;
	private List<Advisor> advisor=new LinkedList<Advisor>();
	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	
	public Class<?> getTargetClass(){
		return target.getClass();
	}

	public Class<?>[] getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(Class<?>[] interfaces) {
		this.interfaces = interfaces;
	}

	public List<Advisor> getAdvisor() {
		return advisor;
	}

	public void setAdvisor(List<Advisor> advisor) {
		this.advisor = advisor;
	}
	
}
