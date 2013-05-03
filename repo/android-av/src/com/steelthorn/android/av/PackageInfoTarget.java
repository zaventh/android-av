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
