package com.zghw.idea.aop;

/**
 * 调用
 * @author zghw
 *
 */
public interface Invocation extends Joinpoint {
	/**
	 * 调用参数
	 * @return
	 */
	Object[] getArguments();
}
