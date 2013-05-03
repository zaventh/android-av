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

import android.util.Log;

public class DefaultScanEngine extends ScanEngine
{
	private static final String TAG = "DefaultScanEngine";

	public void scan(ScanContext ctx, IScanDefinitionProvider provider)
	{
		if (ctx == null)
			throw new IllegalArgumentException("A scan context must be supplied");

		if (ctx.getListener() == null)
			throw new IllegalArgumentException("An IScanListener must be set on the context.");

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

			ctx.getListener().onTargetSourceSwitch(source);

			for (IScanTarget target : source)
			{
				if (_cancel)
				{
					Log.i(TAG, "Scan canceled by user request.");

					ctx.getListener().onScanCanceled(result);
					return;
				}

				ctx.getListener().onTargetScanBegin(target);

				IThreatInfo ti = scanTarget(target, provider);

				progressCount++;

				ctx.getListener().onScanProgress(progressCount / totalCount);

				if (ti != null)
					result.addMatchFound(ti);

				ctx.getListener().onTargetScanComplete(target, ti);
			}
		}

		ctx.getListener().onScanCompleted(result);

		return;
	}

	public IThreatInfo scanTarget(IScanTarget target, IScanDefinitionProvider provider)
	{
		// O(n^2) scanning algorithm for now
		// TODO: BST engine based on size
		//List<IScanDefinitionGroup> groups = Util.getDevDefinitions();

		for (IScanDefinitionGroup group : provider.getDefinitions())
		{
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
