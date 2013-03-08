package com.steelthorn.android.av.kd;

import com.steelthorn.android.av.IScanDefinition;
import com.steelthorn.android.av.IScanDefinitionGroup;


public abstract class KdScanDefinitionGroup extends TwoDPoint implements IScanDefinitionGroup
{
	public KdScanDefinitionGroup(int x, int y)
	{
		super(x, y);
	}




	private double _x = Integer.MIN_VALUE;
	private double _y = Integer.MAX_VALUE;
	


	
	private void populateCoordinates()
	{	
		for (IScanDefinition def : getDefinitions())
		{
			// highest value
			if (def.getMatchSize() > _x)
				_x = def.getMatchSize();
			
			// lowest value
			if (def.getMatchSize() < _y)
				_y = def.getMatchSize();
		}
	}
}
