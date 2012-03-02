package com.steelthorn.android.av.test;

import junit.framework.Assert;

import org.junit.Test;

import android.test.AndroidTestCase;

import com.steelthorn.android.av.IScanTarget;
import com.steelthorn.android.av.ScanEngine;
import com.steelthorn.android.av.ScanManager;
import com.steelthorn.android.av.ScanResult;
import com.steelthorn.android.av.ThreatInfo;

public class StandardTests extends AndroidTestCase {

	@Test
	public void testMatch() throws Exception
	{
		IScanTarget target = new IScanTarget()
		{
			
			public long getSize()
			{
				return 23;
			}
			
			public byte[] getHashValue()
			{
				return hexStringToByteArray("6b1c8ab438bd5e05b99cadc4c09b1398a75a7be9");
			}
		};
		
		ThreatInfo ti = ScanEngine.getDefaultScanEngine().scanTarget(target);
		
		Assert.assertNotNull(ti);
		
		
	}
	
	@Test
	public void testBasicScan() throws Exception
	{
		ScanResult result = new ScanManager().performBasicScan(getContext(), null);
		
		Assert.assertNotNull(result);
	}
	
	 static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
}
