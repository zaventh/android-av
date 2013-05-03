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
