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

public abstract class ScanEngine implements IScanEngine
{
	protected boolean _cancel;
	
	public static ScanEngine getDefaultScanEngine()
	{
		return new DefaultScanEngine();
	}
	
	public void cancel()
	{
		_cancel = true;
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
