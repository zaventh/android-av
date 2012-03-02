package com.steelthorn.android.av;

import java.lang.ref.WeakReference;

import android.content.Context;

public abstract class ScanContext
{
	final WeakReference<Context> _weakContext;
	final IScanListener _listener;
	
	protected ScanContext(Context androidContext, IScanListener listener)
	{
		_weakContext = new WeakReference<Context>(androidContext);
		_listener = listener;
	}
	
	public Context getAndroidContext()
	{
		return _weakContext.get();
	}
	
	protected IScanListener getListener()
	{
		return _listener;
	}
	
	public abstract ITargetSource[] getSources();
}
