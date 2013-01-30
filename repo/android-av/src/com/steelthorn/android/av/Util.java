package com.steelthorn.android.av;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

class Util
{
	public static List<PackageInfo> getInstalledPackages(Context ctx)
	{
		List<PackageInfo> packages = ctx.getPackageManager().getInstalledPackages(0);

		List<PackageInfo> nonSystemPackages = new ArrayList<PackageInfo>();

		for (PackageInfo pack : packages)
		{
			if ((pack.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == ApplicationInfo.FLAG_SYSTEM)
				continue;

			nonSystemPackages.add(pack);
		}

		return nonSystemPackages;
	}

	public static List<IScanDefinition> getDevDefinitions()
	{
		List<IScanDefinition> def = new ArrayList<IScanDefinition>();

		def.add(new IScanDefinition()
		{

			public long getSize()
			{
				return 23;
			}

			public byte[] getHashValue()
			{
				return Base64.decode("3YnpxrvKu5hZxi0m/FkpE+pUcwQ=", Base64.DEFAULT);
			}
		});

		return def;
	}
}
