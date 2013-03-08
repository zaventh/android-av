package com.steelthorn.android.av;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.steelthorn.android.av.kd.KdScanDefinitionGroup;

public class StandardTests extends ScanTests
{
	//private static final String TEST_PACKAGE = "com.example.android.softkeyboard";
	private static final String TEST_PACKAGE = "com.rdio.android.ui";
	//private static final String TEST_PACKAGE_PARTIAL = "com.example.android.soft";
	private static final String TEST_PACKAGE_PARTIAL = "com.rdio.android";
	//private static final String TEST_PARTIAL_WEIGHT1 = "com.example";
	private static final String TEST_PARTIAL_WEIGHT1 = "com.rdio";
	//private static final String TEST_PARTIAL_WEIGHT2 = "android.softkeyboard";
	private static final String TEST_PARTIAL_WEIGHT2 = "android.ui";
	
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

			@Override
			public int compareTo(IScanTarget another)
			{
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public long getSize()
			{
				return getHashValue().length;
			}
		};

		IThreatInfo ti = ScanEngine.getDefaultScanEngine().scanTarget(target, new DevDefinitionProvider());

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

		TestDefinition criteria = createDefGroup(TEST_PACKAGE);

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

		TestDefinition criteria = createDefGroup(TEST_PACKAGE);
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

		TestDefinition criteria = createDefGroup(TEST_PACKAGE);
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

		TestDefinition criteria = createDefGroup(TEST_PACKAGE);
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

		TestDefinition criteria = createDefGroup(TEST_PACKAGE_PARTIAL);

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

		TestDefinition criteria = createDefGroup(TEST_PACKAGE_PARTIAL);
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

		TestDefinition criteria = createDefGroup(TEST_PACKAGE_PARTIAL);
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
				engine.scan(new BasicScanContext(getContext(), listenMock), new DevDefinitionProvider());
			}
		}.start();
		
		engine.cancel();
		
		Thread.sleep(250);
		
		verify(listenMock).onScanCanceled(any(ScanResult.class));
	}
	
	@Test
	public void testPartialWeightMatch() throws Exception
	{
		DebugScanListener listener = new DebugScanListener();
		
		TestDefinition def1 = createDefGroup(TEST_PARTIAL_WEIGHT1);
		def1.setWeight(.5);
		
		TestDefinition def2 = createDefGroup(TEST_PARTIAL_WEIGHT2);
		def2.setMatchPos(12);
		def2.setWeight(.5);
		
		final ArrayList<IScanDefinition> defArray = new ArrayList<IScanDefinition>();
		defArray.add(def1); defArray.add(def2);
		
		IScanDefinitionGroup group = new KdScanDefinitionGroup(TEST_PARTIAL_WEIGHT1.length() <= TEST_PARTIAL_WEIGHT2.length() ? TEST_PARTIAL_WEIGHT1.length() : TEST_PARTIAL_WEIGHT2.length(),
				TEST_PARTIAL_WEIGHT1.length() >= TEST_PARTIAL_WEIGHT2.length() ? TEST_PARTIAL_WEIGHT1.length() : TEST_PARTIAL_WEIGHT2.length())
		{
			@Override
			public List<IScanDefinition> getDefinitions()
			{
				return defArray;
			}
			
			@Override
			public byte getDefinitionType()
			{
				return DefinitionType.ANDROID_PACKAGE;
			}
			
			@Override
			public int getDefinitionGroupId()
			{
				return 1;
			}
		};
		
		final List<IScanDefinitionGroup> defGroupArray = new ArrayList<IScanDefinitionGroup>();
		defGroupArray.add(group);
		
		ScanEngine se = ScanEngine.getDefaultScanEngine();
		
		se.scan(new BasicScanContext(getContext(), listener), new IScanDefinitionProvider()
		{
			
			@Override
			public List<IScanDefinitionGroup> getDefinitions()
			{
				return defGroupArray;
			}
		});
		
		assertTrue(listener._lastResult.getMatchedTargets().get(0).getConfidence() == 1);
	}
	
	@Test
	public void testPartialWeightAnyMatch() throws Exception
	{
		DebugScanListener listener = new DebugScanListener();
		
		TestDefinition def1 = createDefGroup(TEST_PARTIAL_WEIGHT1);
		def1.setWeight(1);
		
		TestDefinition def2 = createDefGroup(TEST_PARTIAL_WEIGHT2);
		def2.setMatchPos(12);
		def2.setWeight(1);
		
		final ArrayList<IScanDefinition> defArray = new ArrayList<IScanDefinition>();
		defArray.add(def1); defArray.add(def2);
		
		IScanDefinitionGroup group = new KdScanDefinitionGroup(TEST_PARTIAL_WEIGHT1.length() <= TEST_PARTIAL_WEIGHT2.length() ? TEST_PARTIAL_WEIGHT1.length() : TEST_PARTIAL_WEIGHT2.length(),
				TEST_PARTIAL_WEIGHT1.length() >= TEST_PARTIAL_WEIGHT2.length() ? TEST_PARTIAL_WEIGHT1.length() : TEST_PARTIAL_WEIGHT2.length())
		{
			
			@Override
			public List<IScanDefinition> getDefinitions()
			{
				return defArray;
			}
			
			@Override
			public byte getDefinitionType()
			{
				return DefinitionType.ANDROID_PACKAGE;
			}
			
			@Override
			public int getDefinitionGroupId()
			{
				return 1;
			}
		};
		
		final List<IScanDefinitionGroup> defGroupArray = new ArrayList<IScanDefinitionGroup>();
		defGroupArray.add(group);
		
		ScanEngine se = ScanEngine.getDefaultScanEngine();
		
		se.scan(new BasicScanContext(getContext(), listener), new IScanDefinitionProvider()
		{
			
			@Override
			public List<IScanDefinitionGroup> getDefinitions()
			{
				return defGroupArray;
			}
		});
		
		assertTrue(listener._lastResult.getMatchedTargets().get(0).getConfidence() == 2);
	}
}
