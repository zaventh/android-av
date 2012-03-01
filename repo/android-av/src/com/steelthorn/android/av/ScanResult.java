package com.steelthorn.android.av;

import java.util.List;

public class ScanResult
{
	private List<IScanTarget> _matchedTargets;
	
	protected ScanResult()
	{
		
	}
	
	public Boolean getMatchesFound()
	{
		return (_matchedTargets != null && _matchedTargets.size() > 0);
	}
	
	public List<IScanTarget> getMatchedTargets()
	{
		return _matchedTargets;
	}
}
