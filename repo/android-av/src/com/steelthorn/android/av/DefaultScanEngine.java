package com.steelthorn.android.av;

import java.util.List;

import android.util.Log;

class DefaultScanEngine extends ScanEngine
{
	private static final String TAG = "DefaultScanEngine";

	public void scan(ScanContext ctx)
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
				if (_cancel)
				{
					Log.i(TAG, "Scan canceled by user request.");
					if (ctx.getListener() != null)
						ctx.getListener().onScanCanceled(result);
					return;
				}

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
		
		if (ctx.getListener() != null)
			ctx.getListener().onScanCompleted(result);

		return;
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
					confidence += def.getWeight();
			}

			if (confidence > 0)
				return new ThreatInfo(target, def, confidence);

		}

		return null;
	}
}
