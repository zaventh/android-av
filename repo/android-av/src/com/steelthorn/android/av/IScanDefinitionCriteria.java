package com.steelthorn.android.av;

public interface IScanDefinitionCriteria
{
	byte[] getHashValue();
	
	long getMatchSize();
	
	double getMatchWeight();
}
