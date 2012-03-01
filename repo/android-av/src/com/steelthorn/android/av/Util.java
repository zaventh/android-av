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
				return hexStringToByteArray("6b1c8ab438bd5e05b99cadc4c09b1398a75a7be9");
			}
		});
		
		return def;
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
}
