package com.steelthorn.android.av;

public interface IScanTarget
{
	byte getTargetType();
	
	String getName();
	
	byte[] getHashValue();
	
	long getSize();
}
