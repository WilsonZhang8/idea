package com.zghw.idea.extract;

import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class StringValueResolverReplace implements StringValueResolver {
	public static final String OLD = "org.springframework";
	public static final String OLD_1 = "org/springframework";
	public static final String NEW = "com.zghw";
	public static final String NEW_1 = "com/zghw";

	public String resolveStringValue(String Content) {
		return Content.replace(OLD, NEW).replace(OLD_1, NEW_1);
	}

}
