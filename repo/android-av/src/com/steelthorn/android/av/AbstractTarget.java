package com.steelthorn.android.av;

abstract class AbstractTarget<T> implements IScanTarget
{
	protected final T _target;
	
	protected AbstractTarget(T target)
	{
		_target = target;
	}
	
	public T getIdentifier()
	{
		return _target;
	}
}
