package com.steelthorn.android.av.kd;

import java.util.List;

import com.steelthorn.android.av.IScanDefinition;
import com.steelthorn.android.av.IScanDefinitionGroup;

class KdScanGroupAdapter extends TwoDPoint implements IScanDefinitionGroup
{
	private final IScanDefinitionGroup _group;
	public KdScanGroupAdapter(IScanDefinitionGroup group)
	{
		super(extractPoint(group));
		_group = group;
	}
	
	private static String extractPoint(IScanDefinitionGroup group)
	{
		double x = Double.POSITIVE_INFINITY;
		double y = Double.NEGATIVE_INFINITY;
		
		for (IScanDefinition def : group.getDefinitions())
		{
			if (def.getMatchSize() < x)
				x = def.getMatchSize();
			
			if (def.getMatchSize() > y)
				y = def.getMatchSize();
		}
		
		return x + "," + y;
	}

	@Override
	public int getDefinitionGroupId()
	{
		return _group.getDefinitionGroupId();
	}

	@Override
	public byte getDefinitionType()
	{
		return _group.getDefinitionType();
	}

	@Override
	public List<IScanDefinition> getDefinitions()
	{
		return _group.getDefinitions();
	}
}
