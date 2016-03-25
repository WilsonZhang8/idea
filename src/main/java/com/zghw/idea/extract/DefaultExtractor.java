package com.zghw.idea.extract;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class DefaultExtractor extends ConfigurableExtractor implements
		RegisterClassDefintion {
	private ReaderContext readerContext;
	@Autowired
	private ClassDefintionReader classDefintionReader;
	@Autowired
	private BuilderClass builderClass;
	private final Map<String, ClassDefintion> register = new HashMap<String, ClassDefintion>();
	@Autowired
	private Resource rootResource;

	public Resource getRootResource() {
		return rootResource;
	}

	public void setRootResource(Resource rootResource) {
		this.rootResource = rootResource;
	}

	public void setRoot(String rootLocation) {
		this.rootResource = getResourceLoader().getResource(rootLocation);
	}

	public void registe(ClassDefintion classDefinition) {
		register.put(classDefinition.getClassName(), classDefinition);
	}

	public ClassDefintion getClassDefinition(String className) {
		return register.get(className);
	}

	public int getClassDefinitionCount() {
		return register.size();
	}

	public String[] getClassDefinitionNames() {
		return (String[]) register.keySet().toArray();
	}

	@Override
	protected void loadBeanDefintion(Resource resource) {
		try {
			classDefintionReader
					.loadClassDefinition(getReaderContext(resource));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected ReaderContext getReaderContext(Resource resource) {
		if (this.readerContext != null) {
			return readerContext;
		}
		return new ReaderContext(resource, this);
	}

	@Override
	protected void buildClass() {
		for (Map.Entry<String, ClassDefintion> entry : register.entrySet()) {
			try {
				builderClass.build(getRootResource(), entry.getValue());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
