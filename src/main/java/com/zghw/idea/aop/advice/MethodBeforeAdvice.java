package com.zghw.idea.aop.advice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.zghw.idea.aop.BeforeAdvice;

public class MethodBeforeAdvice implements BeforeAdvice {
	private Method beforeMethod;
	private Object apectObject;

	public MethodBeforeAdvice(Method beforeMethod,Object apectObject) {
		this.beforeMethod = beforeMethod;
		this.apectObject = apectObject;
	}
	
	public void before(Method method, Object[] args, Object target) {
		try {
			if(beforeMethod.getName().lastIndexOf(method.getName())!=-1){
				beforeMethod.invoke(apectObject);
			}
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
