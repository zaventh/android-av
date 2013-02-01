package com.steelthorn.android.av;

import android.content.pm.PackageInfo;

class PackageInfoTarget extends AbstractTarget<PackageInfo>
{
	private byte[] _hash;

	protected PackageInfoTarget(PackageInfo target)
	{
		super(target);
	}

	@Override
	protected byte[] getBytesToHash()
	{
		return _target.packageName.getBytes();
	}

	public long getSize()
	{
		return _hash.length;
	}

	public String getName()
	{
		return _target.packageName;
	}

	public byte getTargetType()
	{
		return DefinitionType.ANDROID_PACKAGE;
	}
}
