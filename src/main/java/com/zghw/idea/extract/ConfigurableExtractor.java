package com.zghw.idea.extract;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

public abstract class ConfigurableExtractor implements Extractor {
	private final String DEFAULT_RESOURCE_PATTERN = "**/*.class";
	@Autowired
	private ResourcePatternResolver resourceLoader;

	public void extract(String locationPattern) throws IOException {
		locationPattern = "file:" + locationPattern + "/"
				+ DEFAULT_RESOURCE_PATTERN;
		Resource[] resources = resourceLoader.getResources(locationPattern);
		if (resources != null) {
			for (Resource resource : resources) {
				loadBeanDefintion(resource);
			}
		}
		buildClass();
	}

	public ResourcePatternResolver getResourceLoader() {
		return resourceLoader;
	}

	public void setResourceLoader(ResourcePatternResolver resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	protected abstract void loadBeanDefintion(Resource resouce);

	protected abstract void buildClass();

}
