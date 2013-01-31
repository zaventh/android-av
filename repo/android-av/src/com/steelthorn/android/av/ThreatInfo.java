package com.steelthorn.android.av;

public class ThreatInfo
{
	private final IScanTarget _target;
	private final IScanDefinition _sig;
	
	protected ThreatInfo(IScanTarget target, IScanDefinition signature)
	{
		_target = target;
		_sig = signature;
	}
	
	public IScanTarget getTarget()
	{
		return _target;
	}
	
	public IScanDefinition getSignature()
	{
		return _sig;
	}
	
	public double getConfidence()
	{
		// TODO: Real confidence
		return 1.0;
	}
}
