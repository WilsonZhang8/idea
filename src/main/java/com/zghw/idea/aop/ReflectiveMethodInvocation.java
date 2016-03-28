package com.zghw.idea.aop;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.core.BridgeMethodResolver;

public class ReflectiveMethodInvocation implements MethodInvocation {
	protected final Object proxy;

	protected final Object target;

	protected final Method method;

	protected Object[] arguments;
	
	private final Class<?> targetClass;
	
	protected final List<MethodInterceptor> interceptors;

	private int count = -1;
	
	public ReflectiveMethodInvocation(Object proxy, Object target,
			Method method, Object[] arguments, Class<?> targetClass,
			List<MethodInterceptor> interceptors) {

		this.proxy = proxy;
		this.target = target;
		this.targetClass = targetClass;
		this.method = BridgeMethodResolver.findBridgedMethod(method);
		this.arguments = arguments;
		this.interceptors = interceptors;
	}
	
	public Object[] getArguments() {
		return this.arguments;
	}

	public Object proceed() throws Throwable {
		if(count==(interceptors.size()-1)){
			return method.invoke(target, arguments);
		}
		MethodInterceptor mi= interceptors.get(++count);
		Object retVal=mi.invoke(this);
		return retVal;
	}

	public Object getThis() {
		return this.target;
	}

	public Method getMethod() {
		return this.method;
	}

}
