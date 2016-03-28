package com.zghw.idea.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ClassUtils;

import com.zghw.idea.aop.advice.MethodAfterAdvice;
import com.zghw.idea.aop.advice.MethodBeforeAdvice;

public class BuilderAdvisor {

	public static Object proxy(Object target, Object apectObject) {
		Class<?> apect = apectObject.getClass();
		AdviceSupport support = new AdviceSupport();
		List<Advisor> advisors = new ArrayList<Advisor>();
		Method[] methods = apect.getMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("before")) {
				MethodBeforeAdvice advice = new MethodBeforeAdvice(method,
						apectObject);
				Advisor advisor = new DefaultAdvisor(advice);
				advisors.add(advisor);
			}

			if (method.getName().startsWith("after")) {
				MethodAfterAdvice advice = new MethodAfterAdvice(method, apectObject);
				Advisor advisor = new DefaultAdvisor(advice);
				advisors.add(advisor);
			}
		}
		support.setTarget(target);
		support.setInterfaces(ClassUtils.getAllInterfaces(target));
		support.setAdvisor(advisors);
		return new JDKProxy(support).getProxy();
	}

}
