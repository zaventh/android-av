package com.steelthorn.android.av;


public interface IScanDefinition 
{
	int getDefinitionId();
	
	byte[] getHashValue();
	
	int getMatchSize();
	
	long getMatchPosition();
	
	double getWeight();
}
