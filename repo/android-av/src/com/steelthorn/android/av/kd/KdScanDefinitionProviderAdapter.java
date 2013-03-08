package com.steelthorn.android.av.kd;

import java.util.ArrayList;
import java.util.List;

import com.steelthorn.android.av.IScanDefinitionGroup;
import com.steelthorn.android.av.IScanDefinitionProvider;

class KdScanDefinitionProviderAdapter implements IScanDefinitionProvider
{
	//private final IScanDefinitionProvider _provider;
	private final List<IScanDefinitionGroup> _groups;
	
	public KdScanDefinitionProviderAdapter(IScanDefinitionProvider provider)
	{
		//_provider = provider;
		_groups = new ArrayList<IScanDefinitionGroup>();
		
		for (IScanDefinitionGroup group : provider.getDefinitions())
		{
			_groups.add(new KdScanGroupAdapter(group));
		}
	}

	@Override
	public List<IScanDefinitionGroup> getDefinitions()
	{
		return _groups;
	}

}
