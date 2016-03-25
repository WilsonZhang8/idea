package com.zghw.idea.extract;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

public class ReaderContext {
	private Resource resource;
	private RegisterClassDefintion register;

	public ReaderContext(Resource resource, RegisterClassDefintion register) {
		this.resource = resource;
		this.register = register;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public RegisterClassDefintion getRegister() {
		return register;
	}

	public void setRegister(RegisterClassDefintion register) {
		this.register = register;
	}

}
