package com.steelthorn.android.av;

import android.content.pm.PackageInfo;

class PackageInfoTarget extends AbstractTarget<PackageInfo>
{
	protected PackageInfoTarget(PackageInfo target)
	{
		super(target);
	}

	@Override
	protected byte[] getBytesToHash(long position, int length)
	{

		byte[] target = _target.packageName.substring((int) position).getBytes();

		if (target.length > length)
			target = Util.truncateArray(target, length);

		return target;
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
