/*******************************************************************************
 * Copyright (c) 2013 Jeff Mixon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * (or any later version, at your option)  which accompanies this distribution,
 * and is available at http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Jeff - initial API and implementation
 ******************************************************************************/
package com.steelthorn.android.av;

class DemoDefinition implements IScanDefinition
{
	private int _id;
	private byte[] _hashValue;
	private int _matchSize;
	private long _matchPos;
	private double _weight = 1;
	
	public DemoDefinition(String packageName, byte[] hash)
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
