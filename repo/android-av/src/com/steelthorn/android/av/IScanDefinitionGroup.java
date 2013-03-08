package com.steelthorn.android.av;

import java.util.List;


public interface IScanDefinitionGroup
{
	public int getDefinitionGroupId();
	
	public byte getDefinitionType();
	
	public List<IScanDefinition> getDefinitions();
}
