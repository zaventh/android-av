package com.steelthorn.android.av;

public interface IScanListener
{
	void onTargetSourceSwitch(ITargetSource currentSource);
	
	void onTargetScanBegin(IScanTarget target);
	void onTargetScanComplete(IScanTarget target, ThreatInfo info);
	
	void onScanCompleted(ScanResult result);
	void onScanProgress(int progress);
	void onScanException(Exception error);
}
