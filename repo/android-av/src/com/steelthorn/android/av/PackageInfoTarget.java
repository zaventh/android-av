package com.steelthorn.android.av;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.pm.PackageInfo;

public class PackageInfoTarget extends AbstractTarget<PackageInfo>
{
	private byte[] _hash;

	protected PackageInfoTarget(PackageInfo target)
	{
		super(target);
	}

	public byte[] getHashValue()
	{
		if (_hash == null)
		{

			//TOOD: Abstract later
			try
			{
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				md.update(_target.packageName.getBytes());
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

	public long getSize()
	{
		return _hash.length;
	}

	public String getName()
	{
		return _target.packageName;
	}

	public String toString()
	{
		return getName();
	}
}
