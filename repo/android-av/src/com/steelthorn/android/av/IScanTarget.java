package com.steelthorn.android.av;

public interface IScanTarget
{
	byte getTargetType();
	
	String getName();
	
	boolean checkThreat(IScanDefinition criteria);
}
