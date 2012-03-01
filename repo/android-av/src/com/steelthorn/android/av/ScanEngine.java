package com.steelthorn.android.av;

public abstract class ScanEngine implements IScanEngine
{
	public static ScanEngine getDefaultScanEngine()
	{
		return new DefaultScanEngine();
	}
	
//	public void scanAsync(final IScanContext ctx, final IScanCallback callback)
//	{
//		new Thread()
//		{
//			public void run()
//			{
//				try
//				{
//					IScanResult result = scan(ctx);
//					if (callback != null)
//						callback.onScanCompleted(result);
//				}
//				catch (Exception e)
//				{
//					if (callback != null)
//						callback.onScanFailed(e);
//				}
//			}
//		}.start();
//	}
}
