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
