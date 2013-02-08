package com.steelthorn.android.av;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import algs.model.IMultiPoint;
import algs.model.kdtree.KDFactory;
import algs.model.kdtree.KDTree;
import algs.model.nd.Hypercube;

public class KdTreeTests extends ScanTests
{	
	@Test
	public void testKdScanEngine() throws Exception
	{
		DebugScanListener listener = new DebugScanListener();
		
		KdScanEngine eng = new KdScanEngine();
		eng.scan(new BasicScanContext(getContext(), listener), new DevDefinitionProvider());
		
		assertNotNull(listener._lastResult);
	}
	
	@Test
	public void testMatch() throws Exception
	{
		DebugScanListener listener = new DebugScanListener();
		
		final List<IScanDefinitionGroup> defs = Util.getDevDefinitions();
		
		IScanDefinitionGroup[] arrDefs = new IScanDefinitionGroup[defs.size()];
		
		KDTree defTree = KDFactory.generate(defs.toArray(arrDefs));
		
		IScanTarget target = new AbstractTarget<String>("com.long.packagename.fortesting.kdimensional.tree")
		{

			@Override
			public byte getTargetType()
			{
				return DefinitionType.ANDROID_PACKAGE;
			}

			@Override
			public String getName()
			{
				return "com.long.packagename.fortesting.kdimensional.tree";
			}

			@Override
			public long getSize()
			{
				// TODO Auto-generated method stub
				return "com.long.packagename.fortesting.kdimensional.tree".getBytes().length;
			}

			@Override
			protected byte[] getBytesToHash(long position, int length)
			{
				return "com.long.packagename.fortesting.kdimensional.tree".getBytes();
			}
		};
		
		ArrayList<IMultiPoint> intersections = defTree.search(new Hypercube(0, target.getSize() , 0, target.getSize()));
		
		assertTrue(intersections.size() > 0);
		
	}
}
