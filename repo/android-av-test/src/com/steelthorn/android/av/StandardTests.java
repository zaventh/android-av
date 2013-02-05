package com.steelthorn.android.av;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import android.test.AndroidTestCase;

public class StandardTests extends AndroidTestCase
{
	
	
	@Override
	protected void setUp() throws Exception
	{
	    super.setUp();
	    Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
	}

	@Test
	public void testMatch() throws Exception
	{
		IScanTarget target = new IScanTarget()
		{
			public String getName()
			{
				return "Test";
			};

			public byte[] getHashValue()
			{
				return Base64.decode("3YnpxrvKu5hZxi0m/FkpE+pUcwQ=", Base64.DEFAULT);
			}

			public byte getTargetType()
			{
				return 1;
			}

			public boolean checkThreat(IScanDefinition criteria)
			{

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
		final DebugScanListener listener = new DebugScanListener();
		
		Thread t = new Thread()
		{
			public void run()
			{
				new ScanManager().performBasicScan(getContext(), listener);
			}
		};
		
		t.start(); t.join();

		Assert.assertFalse(listener._lastResult.getMatchesFound());
	}

	@Test
	public void testPositivePackage() throws Exception
	{
		ITargetSource source = new InstalledTargetSource(getContext());

		TestDefinition criteria = createDefGroup("com.example.android.softkeyboard");

		boolean matchFound = false;
		for (IScanTarget t : source)
		{
			matchFound = t.checkThreat(criteria);

			if (matchFound)
				break;
		}

		Assert.assertTrue(matchFound);
	}

	@Test
	public void testIncorrectPosition() throws Exception
	{
		ITargetSource source = new InstalledTargetSource(getContext());

		TestDefinition criteria = createDefGroup("com.example.android.softkeyboard");
		criteria.setMatchPos(1);

		boolean matchFound = false;
		for (IScanTarget t : source)
		{
			matchFound = t.checkThreat(criteria);

			if (matchFound)
				break;
		}

		Assert.assertFalse(matchFound);
	}

	@Test
	public void testIncorrectLengthShallow() throws Exception
	{
		ITargetSource source = new InstalledTargetSource(getContext());

		TestDefinition criteria = createDefGroup("com.example.android.softkeyboard");
		//criteria.setMatchPos(criteria.getMatchPosition()-1);
		criteria.setMatchSize(criteria.getMatchSize()-1);

		boolean matchFound = false;
		for (IScanTarget t : source)
		{
			matchFound = t.checkThreat(criteria);

			if (matchFound)
				break;
		}

		Assert.assertFalse(matchFound);
	}

	@Test
	public void testIncorrectLengthDeepStillMatches() throws Exception
	{
		ITargetSource source = new InstalledTargetSource(getContext());

		TestDefinition criteria = createDefGroup("com.example.android.softkeyboard");
		criteria.setMatchSize(criteria.getMatchSize() + 1);

		boolean matchFound = false;
		for (IScanTarget t : source)
		{
			matchFound = t.checkThreat(criteria);

			if (matchFound)
				break;
		}

		Assert.assertTrue(matchFound);
	}

	@Test
	public void testPartialPositive() throws Exception
	{
		ITargetSource source = new InstalledTargetSource(getContext());

		TestDefinition criteria = createDefGroup("com.example.android.soft");

		boolean matchFound = false;
		for (IScanTarget t : source)
		{
			matchFound = t.checkThreat(criteria);

			if (matchFound)
				break;
		}

		Assert.assertTrue(matchFound);
	}

	@Test
	public void testPartialIncorrectLength() throws Exception
	{
		ITargetSource source = new InstalledTargetSource(getContext());

		TestDefinition criteria = createDefGroup("com.example.android.soft");
		criteria.setMatchSize(criteria.getMatchSize()+1);

		boolean matchFound = false;
		for (IScanTarget t : source)
		{
			matchFound = t.checkThreat(criteria);

			if (matchFound)
				break;
		}

		Assert.assertFalse(matchFound);
	}

	@Test
	public void testPartialIncorrectLengthShallow() throws Exception
	{
		ITargetSource source = new InstalledTargetSource(getContext());

		TestDefinition criteria = createDefGroup("com.example.android.soft");
		criteria.setMatchSize(criteria.getMatchSize()-1);

		boolean matchFound = false;
		for (IScanTarget t : source)
		{
			matchFound = t.checkThreat(criteria);

			if (matchFound)
				break;
		}

		Assert.assertFalse(matchFound);
	}
	
	@Test
	public void testScanCancel() throws Exception
	{
		final IScanListener listenMock = mock(IScanListener.class);
		
		final ScanEngine engine = ScanEngine.getDefaultScanEngine();		
		
		new Thread() {
			public void run()
			{
				engine.scan(new BasicScanContext(getContext(), listenMock));
			}
		}.start();
		
		engine.cancel();
		
		Thread.sleep(250);
		
		verify(listenMock).onScanCanceled(any(ScanResult.class));
	}
	
	private TestDefinition createDefGroup(final String packageName)
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
