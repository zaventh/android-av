package com.steelthorn.android.av;

class ThreatInfo implements IThreatInfo
{
	private final IScanTarget _target;
	private final IScanDefinitionGroup _sig;
	private final double _confidence;
	
	protected ThreatInfo(IScanTarget target, IScanDefinitionGroup signature, double confidence)
	{
		_target = target;
		_sig = signature;
		_confidence = confidence;
	}
	
	public IScanTarget getTarget()
	{
		return _target;
	}
	
	public IScanDefinitionGroup getSignature()
	{
		return _sig;
	}
	
	public double getConfidence()
	{
		return _confidence;
	}
}
