package com.zghw.idea.aop;

/**
 * 方法拦截器
 * 
 * @author zghw
 *
 */
public interface MethodInterceptor extends Interceptor {
	/**
	 * 
	 * @param invocation
	 *            方法调用
	 * @return 方法调用返回对象
	 * @throws Throwable
	 */
	Object invoke(MethodInvocation invocation) throws Throwable;
}
