/*******************************************************************************
 * Copyright (c) 2013 Jeff Mixon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * (or any later version, at your option)  which accompanies this distribution,
 * and is available at http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Jeff - initial API and implementation
 ******************************************************************************/
package com.steelthorn.android.av;

public class ThreatInfo implements IThreatInfo
{
	private final IScanTarget _target;
	private final IScanDefinitionGroup _sig;
	private final double _confidence;
	
	public ThreatInfo(IScanTarget target, IScanDefinitionGroup signature, double confidence)
	{
		_target = target;
		_sig = signature;
		_confidence = confidence;
	}
	
	public IScanTarget getTarget()
	{
		return _target;
	}
	
	public IScanDefinitionGroup getSignature()
	{
		return _sig;
	}
	
	public double getConfidence()
	{
		return _confidence;
	}
}
