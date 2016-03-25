package com.zghw.idea.extract;

public interface RegisterClassDefintion {

	public void registe(ClassDefintion classDefinition);

	public ClassDefintion getClassDefinition(String className);

	public int getClassDefinitionCount();

	public String[] getClassDefinitionNames();
}
