package com.steelthorn.android.av.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import android.content.pm.PackageInfo;
import android.test.AndroidTestCase;

import com.steelthorn.android.av.Util;

public class StandardTests extends AndroidTestCase {

	@Test
	public void testSetup() throws Exception
	{
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void testPackages() throws Exception
	{
		List<PackageInfo> packags = Util.getInstalledPackages(getContext());
		
		Assert.assertTrue(packags.size() > 0);
	}
}
