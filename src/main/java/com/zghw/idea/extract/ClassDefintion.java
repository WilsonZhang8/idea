package com.zghw.idea.extract;

import java.util.List;

public interface ClassDefintion {
	public String getPackageName();

	public void setPackageName(String packageName);

	public String getAccessModifier();

	public void setAccessModifier(String accessModifier);

	public String getClassName();

	public void setClassName(String className);

	public String getParentClassName();

	public void setParentClassName(String parentClassName);

	public List<String> getInterfaceNames();

	public void setInterfaceNames(List<String> interfaceNames);

	public boolean isAbstract();

	public void setAbstract(boolean isAbstract);

	public boolean isInterface();

	public void setInterface(boolean isInterface);
}
