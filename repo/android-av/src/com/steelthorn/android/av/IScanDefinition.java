package com.steelthorn.android.av;

import java.util.List;

public interface IScanDefinition
{
	byte getDefinitionType();
	
	List<IScanDefinitionCriteria> getCriterion();
}
