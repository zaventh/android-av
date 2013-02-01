package com.steelthorn.android.av;

public class ThreatInfo implements IThreatInfo
{
	private final IScanTarget _target;
	private final IScanDefinition _sig;
	private final double _confidence;
	
	protected ThreatInfo(IScanTarget target, IScanDefinition signature, double confidence)
	{
		_target = target;
		_sig = signature;
		_confidence = confidence;
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
		return _confidence;
	}
}
