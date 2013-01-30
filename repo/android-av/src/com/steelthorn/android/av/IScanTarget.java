package com.steelthorn.android.av;

public interface IScanTarget
{
	String getName();
	
	byte[] getHashValue();
	
	long getSize();
}
