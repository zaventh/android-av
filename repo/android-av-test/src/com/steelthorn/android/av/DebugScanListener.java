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

import com.steelthorn.android.av.IScanListener;
import com.steelthorn.android.av.IScanTarget;
import com.steelthorn.android.av.ITargetSource;
import com.steelthorn.android.av.IThreatInfo;
import com.steelthorn.android.av.ScanResult;

public class DebugScanListener implements IScanListener
{
	private static final String TAG = "DebugScanListener";
	
	protected ScanResult _lastResult;

	public void onTargetSourceSwitch(ITargetSource currentSource)
	{

		Log.d(TAG, "Target switched to " + currentSource);

	}

	public void onTargetScanBegin(IScanTarget target)
	{
		Log.d(TAG, "Scanning " + target);

	}

	public void onTargetScanComplete(IScanTarget target, IThreatInfo info)
	{
	}

	public void onScanCompleted(ScanResult result)
	{
		Log.d(TAG, "Scan completed.");
		_lastResult = result;

	}

	public void onScanProgress(double progress)
	{
		Log.d(TAG, "Scan progress: " + (progress * 100));
	}

	public void onScanException(Exception error)
	{
		Log.d(TAG, "An error occurred while scanning: " + error.getMessage());
	}

	public void onScanCanceled(ScanResult result)
	{
		Log.d(TAG, "Scan canceled.");
	}

}
