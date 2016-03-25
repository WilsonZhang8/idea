package com.zghw.idea.extract;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.PropertyPlaceholderHelper;

@Configuration
@ComponentScan
public class Application {
	@Value("file:/home/zghw/extractClass")
	private String rootPath;
	@Value("classpath:temple.java")
	private String templePath;

	@Bean
	public MetadataReaderFactory metadataReaderFactory() {
		return new SimpleMetadataReaderFactory();
	}

	@Bean
	public ResourcePatternResolver resourceLoader() {
		return new PathMatchingResourcePatternResolver();
	}

	@Bean
	public Resource rootResource() {
		return resourceLoader().getResource(rootPath);
	}

	@Bean
	public Resource resourceTemple() {
		return resourceLoader().getResource(templePath);
	}

	@Bean
	public PropertyPlaceholderHelper propertyPlaceholderHelper() {
		return new PropertyPlaceholderHelper("${", "}");
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				Application.class);
		Extractor extractor = (Extractor) ctx.getBean("defaultExtractor");
		try {
			extractor.extract("/home/zghw/classjar/aop/org");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
