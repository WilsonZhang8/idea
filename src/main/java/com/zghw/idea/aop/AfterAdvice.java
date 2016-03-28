package com.zghw.idea.aop;

import java.lang.reflect.Method;

/**
 * 后置通知
 * 
 * @author zghw
 *
 */
public interface AfterAdvice extends Advice {
	void after(Method method, Object[] args,
			Object target) throws Throwable;
}
