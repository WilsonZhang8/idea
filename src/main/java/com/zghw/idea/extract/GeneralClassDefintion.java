package com.zghw.idea.extract;

import java.util.List;

public class GeneralClassDefintion implements ClassDefintion {
	private boolean isAbstract;
	private boolean isInterface;
	private String packageName;
	private String accessModifier;
	private String className;
	private String parentClassName;
	private List<String> interfaceNames;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(String accessModifier) {
		this.accessModifier = accessModifier;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getParentClassName() {
		return parentClassName;
	}

	public void setParentClassName(String parentClassName) {
		this.parentClassName = parentClassName;
	}

	public List<String> getInterfaceNames() {
		return interfaceNames;
	}

	public void setInterfaceNames(List<String> interfaceNames) {
		this.interfaceNames = interfaceNames;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public boolean isInterface() {
		return isInterface;
	}

	public void setInterface(boolean isInterface) {
		this.isInterface = isInterface;
	}

}
