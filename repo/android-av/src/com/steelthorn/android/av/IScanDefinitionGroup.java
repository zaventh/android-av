package com.steelthorn.android.av;

import java.util.List;

import com.steelthorn.android.av.kd.IMultiPoint;


public interface IScanDefinitionGroup
{
	public int getDefinitionGroupId();
	
	public byte getDefinitionType();
	
	public List<IScanDefinition> getDefinitions();
}
