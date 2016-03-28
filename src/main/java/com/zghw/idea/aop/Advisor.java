package com.zghw.idea.aop;

/**
 * 通知者
 * @author zghw
 *
 */
public interface Advisor {
	/**
	 * 得到通知
	 * @return
	 */
	Advice getAdvice();
}
