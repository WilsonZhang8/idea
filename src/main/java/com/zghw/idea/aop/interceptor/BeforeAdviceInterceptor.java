package com.zghw.idea.aop.interceptor;

import com.zghw.idea.aop.BeforeAdvice;
import com.zghw.idea.aop.MethodInterceptor;
import com.zghw.idea.aop.MethodInvocation;

public class BeforeAdviceInterceptor implements MethodInterceptor {
	private final BeforeAdvice advice;

	public BeforeAdviceInterceptor(BeforeAdvice advice) {
		this.advice = advice;
	}

	public Object invoke(MethodInvocation mi) throws Throwable {
		advice.before(mi.getMethod(), mi.getArguments(), mi.getThis());
		return mi.proceed();
	}

}
