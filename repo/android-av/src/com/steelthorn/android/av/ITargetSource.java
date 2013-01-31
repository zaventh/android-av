package com.steelthorn.android.av;


public interface ITargetSource extends Iterable<IScanTarget>
{	
	//Iterator<IScanTarget> getTargets();
	public String getName();
	
	public int getTargetCount();
}
