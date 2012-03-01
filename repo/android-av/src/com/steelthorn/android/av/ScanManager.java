package com.steelthorn.android.av;

import android.content.Context;

public class ScanManager
{
	public ScanResult performBasicScan(Context appCtx)
	{
		ScanEngine engine = new DefaultScanEngine();
		
		IScanContext ctx = new InstalledScanContext(appCtx);
		
		return engine.scan(ctx);
		
		
	}
}
