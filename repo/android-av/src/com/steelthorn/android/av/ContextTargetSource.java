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
import java.util.Iterator;

import android.content.Context;

abstract class ContextTargetSource<T> implements ITargetSource
{
	final WeakReference<Context> _weakContext;
	
	protected ContextTargetSource(Context ctx)
	{
		_weakContext = new WeakReference<Context>(ctx);
	}

	public Context getContext()
	{
		return _weakContext.get();
	}
	
	public Iterator<IScanTarget> iterator()
	{
		Iterator<T> iter = getInternalIterator();
		
		return new ScanTargetIteratorWrapper(iter);
	}

	protected abstract Iterator<T> getInternalIterator();
	
	protected abstract IScanTarget getTargetForT(T rawTarget);
	
	class ScanTargetIteratorWrapper implements Iterator<IScanTarget>
	{
		private final Iterator<T> _iter;
		
		protected ScanTargetIteratorWrapper(Iterator<T> iter)
		{
			_iter = iter;
		}

		public boolean hasNext()
		{
			return _iter.hasNext();
		}

		public IScanTarget next()
		{
			return getTargetForT(_iter.next());
		}

		public void remove()
		{
			_iter.remove();
		}
		
	}

}
