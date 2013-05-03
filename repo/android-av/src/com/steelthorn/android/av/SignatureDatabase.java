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

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SignatureDatabase extends SQLiteOpenHelper
{
	public SignatureDatabase()
	{
		super(null,null,null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2)
	{
		// TODO Auto-generated method stub

	}

}
