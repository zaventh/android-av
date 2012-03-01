/**
 * 
 */
package com.steelthorn.android.av;

/**
 *
 */
public interface IScanEngine
{
	ScanResult scan(IScanContext ctx);
	
	Boolean scanTarget(IScanTarget target);
	//void scanAsync(IScanContext ctx, IScanCallback callback);
}
