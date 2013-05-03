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
