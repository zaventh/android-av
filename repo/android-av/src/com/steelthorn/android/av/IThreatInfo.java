package com.steelthorn.android.av;

public interface IThreatInfo
{
	public IScanTarget getTarget();
	
	public IScanDefinition getSignature();
	
	public double getConfidence();
}
