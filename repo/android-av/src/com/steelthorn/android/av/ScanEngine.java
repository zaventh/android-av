package com.steelthorn.android.av;

abstract class ScanEngine implements IScanEngine
{
	public void performScanAsync(final IScanContext ctx, final IScanCallback callback)
	{
		new Thread()
		{
			public void run()
			{
				try
				{
					IScanResult result = performScan(ctx);
					if (callback != null)
						callback.onScanCompleted(result);
				}
				catch (Exception e)
				{
					if (callback != null)
						callback.onScanFailed(e);
				}
			}
		}.start();
	}
}
