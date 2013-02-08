package com.steelthorn.android.av;

import algs.model.IPoint;
import algs.model.kdtree.DimensionalNode;
import algs.model.kdtree.IVisitKDNode;
import algs.model.kdtree.KDFactory;
import algs.model.kdtree.KDTree;
import algs.model.nd.Hypercube;
import android.util.Log;

class KdScanEngine extends DefaultScanEngine
{
	private static final String TAG = "KdScanEngine";

	@Override
	public ThreatInfo scanTarget(final IScanTarget target, IScanDefinitionProvider provider)
	{
		//BinarySearchTree<>
		IPoint[] points = new IPoint[provider.getDefinitions().size()];
		
		
		KDTree tree = KDFactory.generate(provider.getDefinitions().toArray(points));
		
		Log.d(TAG, "Hypercube found results numbering: " + tree.count());
		
		tree.search(new Hypercube (0, target.getSize(),
				0, target.getSize()), new IVisitKDNode() {
			public void visit(DimensionalNode node) {
				Log.d(TAG, "*" + node.toString());
				
//				IScanDefinition def = (IScanDefinition)node.point;
//				
//				target.checkThreat(def);
			}
			public void drain(DimensionalNode node) {
				Log.d(TAG, "+" + node.toString());
			}
		});
		//tree.sea
		
		return null;
	}
	
	

}