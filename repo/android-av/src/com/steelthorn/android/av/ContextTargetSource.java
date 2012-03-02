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
