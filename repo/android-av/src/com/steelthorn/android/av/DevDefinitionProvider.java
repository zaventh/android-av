package com.steelthorn.android.av;

import java.util.List;

class DevDefinitionProvider implements IScanDefinitionProvider
{

	public List<IScanDefinitionGroup> getDefinitions()
	{
		return Util.getDevDefinitions();
	}

}
