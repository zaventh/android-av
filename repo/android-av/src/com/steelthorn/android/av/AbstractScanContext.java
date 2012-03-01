package com.steelthorn.android.av;

import java.lang.ref.WeakReference;
import java.util.List;

import android.content.Context;

abstract class AbstractScanContext implements IScanContext
{
	final WeakReference<Context> _weakContext;
	
	protected AbstractScanContext(Context ctx)
	{
		_weakContext = new WeakReference<Context>(ctx);
	}

	public Context getContext()
	{
		return _weakContext.get();
	}

	public abstract List<IScanTarget> getTargets();

}
