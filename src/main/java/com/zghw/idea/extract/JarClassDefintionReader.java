package com.zghw.idea.extract;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component
public class JarClassDefintionReader implements ClassDefintionReader {
	@Autowired
	private MetadataReaderFactory metadataReadFactory;

	public int loadClassDefinition(ReaderContext readerContext)
			throws IOException {
		MetadataReader metadataReader = metadataReadFactory
				.getMetadataReader(readerContext.getResource());
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		ClassDefintion classDefinition = fill(classMetadata);
		if (classDefinition != null) {
			readerContext.getRegister().registe(classDefinition);
		}
		return 0;
	}

	protected ClassDefintion fill(ClassMetadata cm) {
		// 排除内部类
		if (cm.getEnclosingClassName() == null) {
			ClassDefintion cd = new GeneralClassDefintion();
			cd.setPackageName(ClassUtils.getPackageName(cm.getClassName()));
			cd.setAccessModifier("public");
			cd.setClassName(cm.getClassName());
			cd.setParentClassName(cm.getSuperClassName());
			cd.setInterfaceNames(Arrays.asList(cm.getInterfaceNames()));
			cd.setInterface(cm.isInterface());
			cd.setAbstract(cm.isAbstract());
			return cd;
		}
		return null;
	}

}
