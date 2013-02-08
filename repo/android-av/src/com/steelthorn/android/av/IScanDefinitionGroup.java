package com.steelthorn.android.av;

import java.util.List;

import algs.model.IPoint;

public interface IScanDefinitionGroup extends IPoint
{
	public int getDefinitionGroupId();
	
	public byte getDefinitionType();
	
	public List<IScanDefinition> getDefinitions();
}
