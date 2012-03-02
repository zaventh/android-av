/**
 * 
 */
package com.steelthorn.android.av;

/**
 *
 */
public interface IScanEngine
{
	ScanResult scan(ScanContext ctx);
	
	ThreatInfo scanTarget(IScanTarget target);
	//void scanAsync(IScanContext ctx, IScanCallback callback);
}
