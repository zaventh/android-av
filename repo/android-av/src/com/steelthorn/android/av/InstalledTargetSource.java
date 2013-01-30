package com.steelthorn.android.av;

import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;

public class InstalledTargetSource extends ContextTargetSource<PackageInfo>
{
	private List<PackageInfo> _packages;
	

	protected InstalledTargetSource(Context ctx)
	{
		super(ctx);
	}

	@Override
	protected Iterator<PackageInfo> getInternalIterator()
	{
		if (_packages == null)
			_packages = Util.getInstalledPackages(getContext());
		
		return _packages.iterator();
	}

	@Override
	protected IScanTarget getTargetForT(PackageInfo rawTarget)
	{
		return new PackageInfoTarget(rawTarget);
	}

	public String getName()
	{
		return "Installed applications";
	}
	
}
