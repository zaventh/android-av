package com.steelthorn.android.av;

public class TestDefinition implements IScanDefinition
{
	private int _id;
	private byte[] _hashValue;
	private int _matchSize;
	private long _matchPos;
	private double _weight = 1;
	
	public TestDefinition(String packageName, byte[] hash)
	{
		_id = packageName.hashCode();
		_matchSize = packageName.getBytes().length;
		_hashValue = hash;
	}
	
	@Override
	public int getDefinitionId()
	{
		return _id;
	}

	@Override
	public byte[] getHashValue()
	{
		return _hashValue;
	}

	@Override
	public int getMatchSize()
	{
		return _matchSize;
	}
	
	public void setMatchSize(int size)
	{
		_matchSize = size;
	}

	@Override
	public long getMatchPosition()
	{
		return _matchPos;
	}
	
	public void setMatchPos(long pos)
	{
		_matchPos = pos;
	}

	@Override
	public double getWeight()
	{
		return _weight;
	}
	
	public void setWeight(double weight)
	{
		_weight = weight;
	}

}
