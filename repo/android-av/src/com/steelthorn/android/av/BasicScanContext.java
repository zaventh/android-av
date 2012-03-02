package com.steelthorn.android.av;

import android.content.Context;

class BasicScanContext extends ScanContext
{
	protected BasicScanContext(Context androidContext, IScanListener listener)
	{
		super(androidContext, listener);
	}

	@Override
	public ITargetSource[] getSources()
	{
		return new ITargetSource[] { new InstalledTargetSource(getAndroidContext()) };
	}

}
