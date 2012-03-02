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
