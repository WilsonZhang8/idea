package com.zghw.idea.extract;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringValueResolver;

@Component
public class BuilderClassFile implements BuilderClass {
	public static final String SUFFIX_JAVA = ".java";
	@Autowired
	private Resource resourceTemple;
	@Autowired
	private ClassFileParserDelegate classFileParserDelegate;
	@Autowired
	private StringValueResolver strResolver;

	public void build(Resource root, ClassDefintion classDefinition)
			throws IOException {
		String temple = StreamUtils.copyToString(
				resourceTemple.getInputStream(), Charset.defaultCharset());
		ParserContext parserContext = classFileParserDelegate.parser(temple,
				classDefinition);
		StringBuffer sb = getFileName(root, classDefinition);
		String fileName = strResolver.resolveStringValue(sb.toString());
		String content = strResolver.resolveStringValue(parserContext
				.getContent());
		File file = new File(fileName);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}

		FileCopyUtils.copy(content.getBytes(), file);
	}

	private StringBuffer getFileName(Resource root,
			ClassDefintion classDefinition) throws IOException {
		StringBuffer sb = new StringBuffer();
		sb.append(root.getURI().getPath() + "/");
		sb.append(ClassUtils.convertClassNameToResourcePath(classDefinition
				.getClassName()));
		sb.append(SUFFIX_JAVA);
		return sb;
	}
}
