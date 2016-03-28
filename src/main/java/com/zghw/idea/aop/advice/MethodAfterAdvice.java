package com.zghw.idea.aop.advice;

import java.lang.reflect.Method;

import com.zghw.idea.aop.AfterAdvice;

public class MethodAfterAdvice implements AfterAdvice {
	private Method afterMethod;
	private Object apectObject;

	public MethodAfterAdvice(Method afterMethod,Object apectObject) {
		this.afterMethod = afterMethod;
		this.apectObject = apectObject;
	}
	
	
	public void after(Method method, Object[] args, Object target)
			throws Throwable {
		if(afterMethod.getName().lastIndexOf(method.getName())!=-1){
			afterMethod.invoke(apectObject);
		}
	}

}
