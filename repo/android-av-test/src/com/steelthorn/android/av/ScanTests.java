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
	
	protected DemoDefinition createDefGroup(final String packageName)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(packageName.getBytes());
			return new DemoDefinition(packageName, md.digest());
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return null;
		
		
	}
}
