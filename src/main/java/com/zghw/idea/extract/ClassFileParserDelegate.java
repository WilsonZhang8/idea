package com.zghw.idea.extract;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.PropertyPlaceholderHelper;

@Component
public class ClassFileParserDelegate {
	@Autowired
	private PropertyPlaceholderHelper propertyPlaceholderHelper;

	public static final String IMPORT = "import ";
	public static final String CLASS = "class";
	public static final String ABSTRACT = "abstract";
	public static final String INTERFACE = "interface";
	public static final String EXTENDS = "extends";
	public static final String IMPLEMENTS = "implements";
	public static final String PACKAGE_NAME = "packageName";
	public static final String IMPORT_NAME = "importName";
	public static final String MODIFIER = "modifier";
	public static final String CLASS_NAME = "className";
	public static final String PARENT_INFO = "parentInfo";
	public static final String INTERFACES_INFO = "interfacesInfo";

	public ParserContext parser(String temple, ClassDefintion classDefinition) {
		Properties properties = new Properties();
		setPackName(properties, classDefinition);
		setImportName(properties, classDefinition);
		setModifier(properties, classDefinition);
		setClassName(properties, classDefinition);
		setParentInfo(properties, classDefinition);
		setInterfacesInfo(properties, classDefinition);
		String content = propertyPlaceholderHelper.replacePlaceholders(temple,
				properties);
		ParserContext parserContext = new ParserContext();
		parserContext.setContent(content);
		return parserContext;
	}

	public void setPackName(Properties properties,
			ClassDefintion classDefinition) {
		properties.setProperty(PACKAGE_NAME, classDefinition.getPackageName());
	}

	public void setImportName(Properties properties,
			ClassDefintion classDefinition) {
		StringBuffer sb = new StringBuffer();
		Set<String> importNames = Collections
				.synchronizedSet(new HashSet<String>());
		String pcn = classDefinition.getPackageName();
		if (classDefinition.getInterfaceNames() != null) {
			for (String interfacz : classDefinition.getInterfaceNames()) {
				String interfas = ClassUtils.getPackageName(interfacz);
				if (!interfas.startsWith("java") && !interfas.equals(pcn)) {
					importNames.add(interfas);
				}
			}
		}
		String parentClassName = classDefinition.getParentClassName();
		if (parentClassName != null) {
			String pnn = ClassUtils.getPackageName(parentClassName);
			if (!parentClassName.startsWith("java") && !pnn.equals(pcn)) {
				importNames.add(pnn);
			}
		}

		if (!importNames.isEmpty()) {
			String pn;
			for (Iterator<String> it = importNames.iterator(); it.hasNext();) {
				pn = it.next();
				if (pn.equals(pcn)) {
					System.out.println(pn + "====" + pcn);
					// it.remove();
				} else {
					sb.append(IMPORT + pn + ".*;");
					sb.append("\n");
				}
			}
		}

		if (!sb.toString().isEmpty()) {
			properties.setProperty(IMPORT_NAME, sb.toString());
		} else {
			properties.setProperty(IMPORT_NAME, " ");
		}
	}

	public void setModifier(Properties properties,
			ClassDefintion classDefinition) {
		StringBuffer sb = new StringBuffer();
		sb.append(classDefinition.getAccessModifier());
		if (classDefinition.isInterface()) {
			sb.append(" " + INTERFACE);
		} else {
			if (classDefinition.isAbstract()) {
				sb.append(" " + ABSTRACT);
			}
			sb.append(" " + CLASS);
		}
		properties.setProperty(MODIFIER, sb.toString());
	}

	public void setClassName(Properties properties,
			ClassDefintion classDefinition) {
		properties.setProperty(CLASS_NAME,
				ClassUtils.getShortName(classDefinition.getClassName()));
	}

	public void setParentInfo(Properties properties,
			ClassDefintion classDefinition) {
		properties.setProperty(PARENT_INFO, " ");
		String parentClassName = classDefinition.getParentClassName();
		if (parentClassName != null) {
			if (!parentClassName.startsWith("java")) {
				properties.setProperty(
						PARENT_INFO,
						EXTENDS + " "
								+ ClassUtils.getShortName(parentClassName));
			}

		}
	}

	public void setInterfacesInfo(Properties properties,
			ClassDefintion classDefinition) {
		properties.setProperty(INTERFACES_INFO, " ");
		if (classDefinition.getInterfaceNames() != null) {
			int i = 0;
			StringBuffer sb = new StringBuffer();
			for (String interfacz : classDefinition.getInterfaceNames()) {
				if (!interfacz.startsWith("java")) {
					if (i == 0) {
						if (classDefinition.isInterface()) {
							sb.append(EXTENDS + " ");
						} else {
							sb.append(IMPLEMENTS + " ");
						}
					} else {
						sb.append(",");
					}
					sb.append(ClassUtils.getShortName(interfacz));
					i++;
				}
			}
			properties.setProperty(INTERFACES_INFO, sb.toString());
		}

	}

}
