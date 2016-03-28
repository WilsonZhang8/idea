package com.zghw.idea.aop;

public class DefaultAdvisor implements Advisor {
	private Advice advice;

	public DefaultAdvisor(Advice advice) {
		this.advice = advice;
	}

	public Advice getAdvice() {
		return advice;
	}

}
