package com.steelthorn.android.av;

public interface IScanCallback
{
	void onScanCompleted(ScanResult result);
	
	void onScanFailed(Exception error);
}
