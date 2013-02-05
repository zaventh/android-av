package com.steelthorn.android.av;

import android.content.Context;

public class ScanManager
{
	public void performBasicScan(Context appCtx, IScanListener listener)
	{
		ScanEngine engine = new DefaultScanEngine();

		ScanContext ctx = new BasicScanContext(appCtx, listener);

		// TODO: Abstract out, obviously
		engine.scan(ctx, new DevDefinitionProvider());
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
