package com.steelthorn.android.av;

import android.content.Context;

public class ScanManager
{
	public void performBasicScan(Context appCtx, IScanListener listener)
	{
		ScanEngine engine = new DefaultScanEngine();

		ScanContext ctx = new BasicScanContext(appCtx, listener);

		engine.scan(ctx);
	}

	public void performBasicScanAsync(final Context appCtx, final IScanListener listener)
	{
		new Thread()
		{
			public void run()
			{
				performBasicScan(appCtx, listener);
			}
		}.start();
	}
}
