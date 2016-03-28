package com.zghw.idea.aop;

import java.lang.reflect.Method;
/**
 * 后置通知
 * @author zghw
 *
 */
public interface BeforeAdvice extends Advice {
	void before(Method method, Object[] args, Object target);
}
