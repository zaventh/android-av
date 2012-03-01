package com.steelthorn.android.av;

import java.util.Arrays;
import java.util.List;

class DefaultScanEngine extends ScanEngine
{

	public ScanResult scan(IScanContext ctx)
	{
		//IScanResult
		return null;
	}

	public Boolean scanTarget(IScanTarget target)
	{
		List<IScanDefinition> defs = Util.getDevDefinitions();
		
		for (IScanDefinition def : defs)
		{
			if (Arrays.equals(def.getHashValue(), target.getHashValue()))
				return true;
		}
		
		return false;
	}
}
