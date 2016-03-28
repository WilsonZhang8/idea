package com.zghw.idea.aop;

/**
 * 连接点
 * 
 * @author zghw
 *
 */
public interface Joinpoint {
	/**
	 * 连接器链
	 * 执行下一个拦截器
	 * @return
	 * @throws Throwable
	 */
	Object proceed() throws Throwable;

	/**
	 * 得到当前的调用
	 * @return
	 */
	Object getThis();
}
