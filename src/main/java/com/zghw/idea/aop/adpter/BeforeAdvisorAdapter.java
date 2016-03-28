package com.zghw.idea.aop.adpter;

import com.zghw.idea.aop.Advice;
import com.zghw.idea.aop.Advisor;
import com.zghw.idea.aop.BeforeAdvice;
import com.zghw.idea.aop.MethodInterceptor;
import com.zghw.idea.aop.interceptor.BeforeAdviceInterceptor;

public class BeforeAdvisorAdapter implements AdvisorAdapter {

	public boolean supportsAdvice(Advice advice) {
		return ((advice) instanceof BeforeAdvice);
	}

	public MethodInterceptor getInterceptor(Advisor advisor) {
		BeforeAdvice afterAdvice = (BeforeAdvice) advisor.getAdvice();
		return new BeforeAdviceInterceptor(afterAdvice);
	}

}
