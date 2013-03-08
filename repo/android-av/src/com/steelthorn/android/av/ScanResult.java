package com.steelthorn.android.av;

import java.util.ArrayList;
import java.util.List;

public class ScanResult
{
	private List<IThreatInfo> _matchedTargets;
	
	protected ScanResult()
	{
		_matchedTargets = new ArrayList<IThreatInfo>();
	}
	
	public Boolean getMatchesFound()
	{
		return (_matchedTargets != null && _matchedTargets.size() > 0);
	}
	
	protected void addMatchFound(IThreatInfo target)
	{
		_matchedTargets.add(target);
	}
	
	public List<IThreatInfo> getMatchedTargets()
	{
		return _matchedTargets;
	}
}
