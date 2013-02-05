package com.steelthorn.android.av;

public interface IThreatInfo
{
	public IScanTarget getTarget();
	
	public IScanDefinitionGroup getSignature();
	
	public double getConfidence();
}
