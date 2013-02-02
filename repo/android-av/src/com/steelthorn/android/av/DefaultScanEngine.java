package com.steelthorn.android.av;

import java.util.List;

import android.util.Log;

class DefaultScanEngine extends ScanEngine
{
	private static final String TAG = "DefaultScanEngine";

	public ScanResult scan(ScanContext ctx)
	{
		ScanResult result = new ScanResult();

		//TODO: Possibly move this to the ScanContext
		double totalCount = 0;
		for (ITargetSource source : ctx.getSources())
		{
			totalCount += source.getTargetCount();
		}

		Log.d(TAG, "Total of " + totalCount + " targets to scan.");

		double progressCount = 0;
		for (ITargetSource source : ctx.getSources())
		{
			if (ctx.getListener() != null)
				ctx.getListener().onTargetSourceSwitch(source);

			for (IScanTarget target : source)
			{
				if (ctx.getListener() != null)
					ctx.getListener().onTargetScanBegin(target);

				ThreatInfo ti = scanTarget(target);

				progressCount++;

				if (ctx.getListener() != null)
					ctx.getListener().onScanProgress(progressCount / totalCount);

				if (ti != null)
					result.addMatchFound(ti);

				if (ctx.getListener() != null)
					ctx.getListener().onTargetScanComplete(target, ti);
			}
		}

		return result;
	}

	public ThreatInfo scanTarget(IScanTarget target)
	{
		// O(n) scanning algorithm for now
		// TODO: BST engine based on size
		List<IScanDefinition> defs = Util.getDevDefinitions();

		for (IScanDefinition def : defs)
		{
			int confidence = 0;
			if ((def.getDefinitionType() == target.getTargetType()))
			{

				if (target.checkThreat(def))
					confidence += def.getMatchWeight();
			}

			if (confidence > 0)
				return new ThreatInfo(target, def, confidence);

		}

		return null;
	}
}
