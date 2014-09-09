package com.skycopyhot.fitnesshelper.core.db;

import android.content.Context;

/**
 * Created by skycopyhot
 * 8/9/14
 */
public abstract class BaseDB implements IDBConstant{
    public FitnessDBHelper mHelper;

    public BaseDB(Context context) {
        mHelper = new FitnessDBHelper(context);
    }
}
