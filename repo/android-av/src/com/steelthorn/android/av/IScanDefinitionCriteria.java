package com.steelthorn.android.av;

public interface IScanDefinitionCriteria
{
	byte[] getHashValue();
	
	long getMatchSize();
	
	long getPosition();
	
	double getMatchWeight();
}
