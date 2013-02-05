/**
 * 
 */
package com.steelthorn.android.av;

/**
 *
 */
public interface IScanEngine
{
	void scan(ScanContext ctx, IScanDefinitionProvider provider);
	
	IThreatInfo scanTarget(IScanTarget target, IScanDefinitionProvider provider);
	
	void cancel();
}
