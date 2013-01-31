package com.steelthorn.android.av;

public interface IScanDefinition
{
	byte getDefinitionType();
	
	byte[] getHashValue();
	
	long getSize();
}
