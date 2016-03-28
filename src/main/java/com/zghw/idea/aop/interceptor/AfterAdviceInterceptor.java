package com.zghw.idea.aop.interceptor;

import com.zghw.idea.aop.AfterAdvice;
import com.zghw.idea.aop.MethodInterceptor;
import com.zghw.idea.aop.MethodInvocation;

public class AfterAdviceInterceptor implements MethodInterceptor {
	private final AfterAdvice advice;

	public AfterAdviceInterceptor(AfterAdvice advice) {
		this.advice = advice;
	}

	public Object invoke(MethodInvocation mi) throws Throwable {
		Object retVal =mi.proceed();
		advice.after(mi.getMethod(), mi.getArguments(), mi.getThis());
		return retVal;
	}

}
