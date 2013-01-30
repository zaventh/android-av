package com.steelthorn.android.av.test;

import android.util.Log;

import com.steelthorn.android.av.IScanListener;
import com.steelthorn.android.av.IScanTarget;
import com.steelthorn.android.av.ITargetSource;
import com.steelthorn.android.av.ScanResult;
import com.steelthorn.android.av.ThreatInfo;

public class DebugScanListener implements IScanListener
{
	private static final String TAG = "DebugScanListener";

	public void onTargetSourceSwitch(ITargetSource currentSource)
	{

		Log.d(TAG, "Target switched to " + currentSource);

	}

	public void onTargetScanBegin(IScanTarget target)
	{
		Log.d(TAG, "Scanning " + target);

	}

	public void onTargetScanComplete(IScanTarget target, ThreatInfo info)
	{

	}

	public void onScanCompleted(ScanResult result)
	{
		Log.d(TAG, "Scan completed.");

	}

	public void onScanProgress(int progress)
	{

	}

	public void onScanException(Exception error)
	{
		Log.d(TAG, "An error occurred while scanning: " + error.getMessage());
	}

}
