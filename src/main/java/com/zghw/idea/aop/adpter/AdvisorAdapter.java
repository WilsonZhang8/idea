package com.zghw.idea.aop.adpter;

import com.zghw.idea.aop.Advice;
import com.zghw.idea.aop.Advisor;
import com.zghw.idea.aop.MethodInterceptor;

public interface AdvisorAdapter {
	
	boolean supportsAdvice(Advice advice);

	MethodInterceptor getInterceptor(Advisor advisor);
}
