package com.steelthorn.android.av;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

abstract class AbstractTarget<T> implements IScanTarget
{
	protected final T _target;
	private byte[] _hash;
	
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
	
	//	@Override
	//	public int hashCode()
	//	{
	//		return getName().hashCode();
	//	}

	protected byte[] getHashValue(long position, int length)
	{
		if (_hash == null)
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return _hash;
	}
	
	public boolean checkThreat(IScanDefinition criteria)
	{
		if (criteria.getDefinitionType() != getTargetType())
			return false;
		
		if (Arrays.equals(criteria.getHashValue(), getHashValue(criteria.getMatchPosition(), criteria.getMatchSize())))
			return true;
		else
			return false;
	}
}
