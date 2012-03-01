package com.steelthorn.android.av;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;

public class InstalledScanContext extends AbstractScanContext
{

	protected InstalledScanContext(Context ctx)
	{
		super(ctx);
	}

	@Override
	public List<IScanTarget> getTargets()
	{
		List<PackageInfo> packages = Util.getInstalledPackages(getContext());
		
		List<IScanTarget> targets = new ArrayList<IScanTarget>();
		
		for (PackageInfo pack : packages)
		{
			targets.add(new PackageInfoTarget(pack));
		}
		
		return targets;
	}
	

}
