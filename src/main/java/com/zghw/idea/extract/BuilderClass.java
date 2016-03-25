package com.zghw.idea.extract;

import java.io.IOException;

import org.springframework.core.io.Resource;

public interface BuilderClass {
	public void build(Resource root, ClassDefintion classDefintion)
			throws IOException;
}
