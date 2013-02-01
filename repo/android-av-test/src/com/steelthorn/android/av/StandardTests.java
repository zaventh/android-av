package com.steelthorn.android.av;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import android.test.AndroidTestCase;

import com.steelthorn.android.av.Base64;
import com.steelthorn.android.av.IScanDefinitionCriteria;
import com.steelthorn.android.av.IScanTarget;
import com.steelthorn.android.av.IThreatInfo;
import com.steelthorn.android.av.ScanEngine;
import com.steelthorn.android.av.ScanManager;
import com.steelthorn.android.av.ScanResult;

public class StandardTests extends AndroidTestCase
{

	@Test
	public void testMatch() throws Exception
	{
		IScanTarget target = new IScanTarget()
		{
			public String getName() { return "Test"; };

			public byte[] getHashValue()
			{
				return Base64.decode("3YnpxrvKu5hZxi0m/FkpE+pUcwQ=", Base64.DEFAULT);
			}

			public byte getTargetType()
			{
				return 1;
			}

			public boolean checkThreat(IScanDefinitionCriteria criteria)
			{
				// TODO Auto-generated method stub
				return Arrays.equals(getHashValue(), criteria.getHashValue());
			}
		};

		IThreatInfo ti = ScanEngine.getDefaultScanEngine().scanTarget(target);

		Assert.assertNotNull(ti);
		
		Assert.assertTrue(ti.getConfidence() >= 1);
	}
	

	@Test
	public void testBasicScan() throws Exception
	{
		ScanResult result = new ScanManager().performBasicScan(getContext(), new DebugScanListener());
		
		Assert.assertFalse(result.getMatchesFound());
	}
	
	@Test
	public void testPositivePackage() throws Exception
	{
		ITargetSource source = new InstalledTargetSource(getContext());
		
		IScanDefinitionCriteria criteria = new IScanDefinitionCriteria()
		{
			
			public long getPosition()
			{
				return -1;
			}
			
			public double getMatchWeight()
			{
				return 1;
			}
			
			public long getMatchSize()
			{
				return "com.example.android.softkeyboard".length();
				//return Base64.decode("CLZof02MBHxFPZwCSwxJcxjamTM=", Base64.DEFAULT).length;
			}
			
			public byte[] getHashValue()
			{

				// com.example.android.softkeyboard
				return Base64.decode("CLZof02MBHxFPZwCSwxJcxjamTM=", Base64.DEFAULT);
			}
		};
		
		boolean matchFound = false;
		for (IScanTarget t : source)
		{
			matchFound = t.checkThreat(criteria);
			
			if (matchFound)
				break;
		}
		
		Assert.assertTrue(matchFound);
	}
}
