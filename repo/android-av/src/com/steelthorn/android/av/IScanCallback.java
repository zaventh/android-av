package com.steelthorn.android.av;

public interface IScanCallback
{
	void onScanCompleted(IScanResult result);
	
	void onScanFailed(Exception error);
}
