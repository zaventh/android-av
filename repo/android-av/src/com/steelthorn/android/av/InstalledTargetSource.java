package com.steelthorn.android.av;

import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;

class InstalledTargetSource extends ContextTargetSource<PackageInfo>
{
	private List<PackageInfo> _packages;
	
	protected InstalledTargetSource(Context ctx)
	{
		super(ctx);
	}
	
	protected List<PackageInfo> getPackages()
	{
		// TODO: Don't preload all packages... iterate
		if (_packages == null)
			_packages = Util.getInstalledPackages(getContext());
		return _packages;
	}

	@Override
	protected Iterator<PackageInfo> getInternalIterator()
	{
		
		return getPackages().iterator();
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

	public int getTargetCount()
	{
		return getPackages().size();
	}
	
}
