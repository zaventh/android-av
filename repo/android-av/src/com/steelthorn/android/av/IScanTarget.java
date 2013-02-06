package com.steelthorn.android.av;

public interface IScanTarget extends Comparable<IScanTarget>
{
	byte getTargetType();
	
	String getName();
	
	long getSize();
	
	boolean checkThreat(IScanDefinition criteria);
}
