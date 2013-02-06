package com.steelthorn.android.av;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

abstract class AbstractTarget<T> implements IScanTarget
{
	protected final T _target;
	private byte[] _hash;
	
	private long _lastPosition;
	
	protected AbstractTarget(T target)
	{
		_target = target;
	}
	
	protected abstract byte[] getBytesToHash(long position, int length);
	
	public T getIdentifier()
	{
		return _target;
	}
	
	@Override
	public String toString()
	{
		return getName();
	}

	protected byte[] getHashValue(long position, int length)
	{
		if (_hash == null || _lastPosition != position)
		{
			//TOOD: Abstract later
			try
			{
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				md.update(getBytesToHash(position, length));
				_hash = md.digest();
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
			
			_lastPosition = position;

		}
		return _hash;
	}
	
	public boolean checkThreat(IScanDefinition criteria)
	{		
		if (Arrays.equals(criteria.getHashValue(), getHashValue(criteria.getMatchPosition(), criteria.getMatchSize())))
			return true;
		else
			return false;
	}
	
	public int compareTo(IScanTarget another)
	{
		return Double.compare(getSize(), another.getSize());
	}
}
