package com.steelthorn.android.av;


public interface IScanDefinition
{
	byte getDefinitionType();
	
	byte[] getHashValue();
	
	int getMatchSize();
	
	long getPosition();
	
	double getMatchWeight();
}
