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
	
	IThreatInfo scanTarget(IScanTarget target);
	
	void cancel();
}
