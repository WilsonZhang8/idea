package com.zghw.idea.aop.adpter;

import com.zghw.idea.aop.Advice;
import com.zghw.idea.aop.Advisor;
import com.zghw.idea.aop.AfterAdvice;
import com.zghw.idea.aop.MethodInterceptor;
import com.zghw.idea.aop.interceptor.AfterAdviceInterceptor;

public class AfterAdvisorAdapter implements AdvisorAdapter {

	public boolean supportsAdvice(Advice advice) {
		return ((advice) instanceof AfterAdvice);
	}

	public MethodInterceptor getInterceptor(Advisor advisor) {
		AfterAdvice afterAdvice = (AfterAdvice) advisor.getAdvice();
		return new AfterAdviceInterceptor(afterAdvice);
	}

}
