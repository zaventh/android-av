package com.steelthorn.android.av;

import java.util.List;

public interface IScanDefinition
{
	byte getDefinitionType();
	
	byte[] getHashValue();
	
	long getMatchSize();
	
	long getPosition();
	
	double getMatchWeight();
}
