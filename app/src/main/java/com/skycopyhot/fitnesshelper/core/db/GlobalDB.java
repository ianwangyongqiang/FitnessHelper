package com.skycopyhot.fitnesshelper.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.skycopyhot.fitnesshelper.core.model.GlobalData;

import java.util.List;

/**
 * Created by skycopyhot on 7/9/14.
 */
public class GlobalDB {

    private FitnessDBHelper mHelper;

    public GlobalDB(Context context) {
        mHelper = new FitnessDBHelper(context);
    }

    public List<GlobalData> queryAll() {
        synchronized (FitnessDBHelper.SYNC_OBJ) {
            SQLiteDatabase db = mHelper.getWritableDatabase();

        }
        return null;
    }
}
