/*******************************************************************************
 * Copyright (c) 2013 Jeff Mixon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * (or any later version, at your option)  which accompanies this distribution,
 * and is available at http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Jeff - initial API and implementation
 ******************************************************************************/
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
