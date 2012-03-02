package com.steelthorn.android.av;

import java.util.List;

public class ScanResult
{
	private List<ThreatInfo> _matchedTargets;
	
	protected ScanResult()
	{
		
	}
	
	public Boolean getMatchesFound()
	{
		return (_matchedTargets != null && _matchedTargets.size() > 0);
	}
	
	protected void addMatchFound(ThreatInfo target)
	{
		_matchedTargets.add(target);
	}
	
	public List<ThreatInfo> getMatchedTargets()
	{
		return _matchedTargets;
	}
}
