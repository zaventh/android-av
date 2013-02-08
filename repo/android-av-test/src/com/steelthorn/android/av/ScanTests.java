package com.steelthorn.android.av;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.test.AndroidTestCase;

abstract class ScanTests extends AndroidTestCase
{
	@Override
	protected void setUp() throws Exception
	{
	    super.setUp();
	    Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
	}
	
	protected TestDefinition createDefGroup(final String packageName)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(packageName.getBytes());
			return new TestDefinition(packageName, md.digest());
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return null;
		
		
	}
}
