package com.steelthorn.android.av;

import android.content.pm.PackageInfo;
import android.util.Log;

class PackageInfoTarget extends AbstractTarget<PackageInfo>
{
	private static String TAG = "PackageInfoTarget";
	
	protected PackageInfoTarget(PackageInfo target)
	{
		super(target);
	}

	@Override
	protected byte[] getBytesToHash(long position, int length)
	{
		Log.d(TAG, "Begin calculating hash for " + _target.packageName);
		
		byte[] target = _target.packageName.substring((int) position).getBytes();

		if (target.length > length)
			target = Util.truncateArray(target, length);

		return target;
	}

	public String getName()
	{
		return _target.packageName;
	}
	
	public long getSize()
	{
		return _target.packageName.length();
	}

	public byte getTargetType()
	{
		return DefinitionType.ANDROID_PACKAGE;
	}
}
