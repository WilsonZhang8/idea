package com.zghw.idea.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import com.zghw.idea.aop.adpter.AdvisorAdapter;
import com.zghw.idea.aop.adpter.AfterAdvisorAdapter;
import com.zghw.idea.aop.adpter.BeforeAdvisorAdapter;

public class JDKProxy implements InvocationHandler {
	private Class<?> targetClass;
	private Object target;
	private AdviceSupport adviceSupport;
	private Class<?>[] interfaces;

	public JDKProxy(AdviceSupport adviceSupport) {
		this.adviceSupport = adviceSupport;
		this.target = adviceSupport.getTarget();
		this.targetClass = adviceSupport.getTargetClass();
		this.interfaces = adviceSupport.getInterfaces();
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(targetClass.getClassLoader(), interfaces,
				this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		List<MethodInterceptor> interceptors = getMethodInterceptor();
		MethodInvocation invocation = new ReflectiveMethodInvocation(proxy,
				target, method, args, targetClass, interceptors);
		Object retValue = invocation.proceed();
		return retValue;
	}

	private List<MethodInterceptor> getMethodInterceptor() {
		List<MethodInterceptor> interceptors = new ArrayList<MethodInterceptor>();
		List<Advisor> advisors = adviceSupport.getAdvisor();
		AdvisorAdapter afterAdapter = new AfterAdvisorAdapter();
		AdvisorAdapter beforeAdapter = new BeforeAdvisorAdapter();
		for (Advisor advisor : advisors) {
			if (afterAdapter.supportsAdvice(advisor.getAdvice())) {
				interceptors.add(afterAdapter.getInterceptor(advisor));
			}
			if (beforeAdapter.supportsAdvice(advisor.getAdvice())) {
				interceptors.add(beforeAdapter.getInterceptor(advisor));
			}
		}

		return interceptors;
	}
}
