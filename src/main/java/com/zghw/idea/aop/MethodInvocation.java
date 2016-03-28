package com.zghw.idea.aop;

import java.lang.reflect.Method;

/**
 * 方法调用
 * @author zghw
 *
 */
public interface MethodInvocation extends Invocation {
	/**
	 * 调用的方法
	 * @return
	 */
	Method getMethod();
}
