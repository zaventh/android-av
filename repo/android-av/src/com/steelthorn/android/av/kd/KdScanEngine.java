package com.steelthorn.android.av.kd;

import java.util.ArrayList;

import android.util.Log;

import com.steelthorn.android.av.DefaultScanEngine;
import com.steelthorn.android.av.IScanDefinition;
import com.steelthorn.android.av.IScanDefinitionGroup;
import com.steelthorn.android.av.IScanDefinitionProvider;
import com.steelthorn.android.av.IScanTarget;
import com.steelthorn.android.av.IThreatInfo;
import com.steelthorn.android.av.ScanContext;
import com.steelthorn.android.av.ThreatInfo;

public class KdScanEngine extends DefaultScanEngine
{
	private static final String TAG = "KdScanEngine";

	@Override
	public void scan(ScanContext ctx, IScanDefinitionProvider provider)
	{
		super.scan(ctx, new KdScanDefinitionProviderAdapter(provider));
	}

	@Override
	public IThreatInfo scanTarget(final IScanTarget target, IScanDefinitionProvider provider)
	{
		// Type check. Java makes me sad.
		if (!(provider instanceof KdScanDefinitionProviderAdapter))
			throw new IllegalArgumentException("Incorrect execution state.");

		IMultiPoint[] points = new IMultiPoint[provider.getDefinitions().size()];

		KDTree tree = KDFactory.generate(provider.getDefinitions().toArray(points));

		Log.d(TAG, "Hypercube found results numbering: " + tree.count());

		//		tree.search(new Hypercube(0, target.getSize(), 0, target.getSize()), new IVisitKDNode()
		//		{
		//			public void visit(DimensionalNode node)
		//			{
		//				Log.d(TAG, "*" + node.toString());
		//
		//				IScanDefinitionGroup defGroup = (IScanDefinitionGroup) node.point;
		//
		//				for (IScanDefinition def : defGroup.getDefinitions())
		//				{
		//					target.checkThreat(def);
		//				}
		//			}
		//
		//			public void drain(DimensionalNode node)
		//			{
		//				Log.d(TAG, "+" + node.toString());
		//			}
		//		});
		//tree.sea

		ArrayList<IMultiPoint> results = tree.search(new Hypercube(0, target.getSize(), 0, target.getSize()));

		for (IMultiPoint mp : results)
		{
			IScanDefinitionGroup group = (IScanDefinitionGroup)mp;
			
			if (!(target.getTargetType() == group.getDefinitionType()))
				continue;

			double confidence = 0;
			for (IScanDefinition def : group.getDefinitions())
			{
				if (target.checkThreat(def))
				{
					confidence += def.getWeight();

					Log.d(TAG, "Target " + target.getName() + " was a match for definition id " + def.getDefinitionId());
				}

				// Break if confidence is already > 1?
			}

			if (confidence >= 1)
				return new ThreatInfo(target, group, confidence);

		}

		return null;
	}
}
