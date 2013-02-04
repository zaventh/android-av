/**
 * 
 */
package com.steelthorn.android.av;

/**
 *
 */
public interface IScanEngine
{
	void scan(ScanContext ctx);
	
	IThreatInfo scanTarget(IScanTarget target);
	
	void cancel();
}
