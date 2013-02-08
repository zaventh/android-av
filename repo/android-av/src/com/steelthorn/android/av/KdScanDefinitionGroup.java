package com.steelthorn.android.av;


abstract class KdScanDefinitionGroup implements IScanDefinitionGroup
{
	private double _x = Integer.MIN_VALUE;
	private double _y = Integer.MAX_VALUE;
	

	@Override
	public double getX()
	{
		if (_x == Integer.MIN_VALUE)
			populateCoordinates();
		return _x;
	}

	@Override
	public double getY()
	{
		if (_y == Integer.MAX_VALUE)
			populateCoordinates();
		
		return _y;
	}
	
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
