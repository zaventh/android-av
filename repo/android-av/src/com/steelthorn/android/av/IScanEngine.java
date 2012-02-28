/**
 * 
 */
package com.steelthorn.android.av;

/**
 *
 */
public interface IScanEngine
{
	IScanResult performScan(IScanContext ctx);
	
	void performScanAsync(IScanContext ctx, IScanCallback callback);
}
