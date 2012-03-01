package com.steelthorn.android.av;

import java.util.List;

import android.content.Context;

public interface IScanContext
{
	Context getContext();
	
	List<IScanTarget> getTargets();
}
