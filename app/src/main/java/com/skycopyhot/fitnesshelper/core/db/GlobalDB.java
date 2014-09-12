package com.skycopyhot.fitnesshelper.core.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.skycopyhot.fitnesshelper.core.model.GlobalData;

import java.util.ArrayList;
import java.util.List;

/**
 * manager the global data
 *
 * Created by skycopyhot on 7/9/14.
 */
public class GlobalDB extends BaseDB{

    public GlobalDB(Context context) {
        super(context);
    }

    /**
     * query all the global data
     * @return the list
     */
    public List<GlobalData> queryAll() {
        List<GlobalData> result = new ArrayList<GlobalData>();
        synchronized (FitnessDBHelper.SYNC_OBJ) {
            SQLiteDatabase db = mHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * from " + SHEET_NAME_GLOBAL, null);
            if (db != null && cursor != null) {
                try {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        int detail = cursor.getInt(cursor.getColumnIndex("detail"));
                        String time = cursor.getString(cursor.getColumnIndex("time"));
                        if (TextUtils.isEmpty(time)) {
                            time = "0";
                        }
                        String other = cursor.getString(cursor.getColumnIndex("other"));
                        int from = cursor.getInt(cursor.getColumnIndex("_id"));
                        GlobalData data = new GlobalData(from, name, time, detail, other);
                        result.add(data);
                    }
                } finally {
                    db.close();
                    cursor.close();
                }
            }


        }
        return result;
    }

    public List<GlobalData> query(int from, int size) {
        List<GlobalData> result = new ArrayList<GlobalData>();
        synchronized (FitnessDBHelper.SYNC_OBJ) {
            SQLiteDatabase db = mHelper.getWritableDatabase();
//TODO            Cursor cursor = db.query(SHEET_NAME_GLOBAL, )
        }

        return  result;
    }

    /**
     * insert the global data
     * @param data
     * @return location of the data, if it returns 0, something goes wrong
     */
    public long insertGlobalData(GlobalData data) {
        if (data == null) {
            return 0;
        }
        long result = 0;
        synchronized (FitnessDBHelper.SYNC_OBJ) {
            SQLiteDatabase db = mHelper.getWritableDatabase();
            result = db.insert(SHEET_NAME_GLOBAL, null, getValues(data));
        }
        return result;
    }

    private ContentValues getValues(GlobalData data) {
        ContentValues values = new ContentValues();
        values.put("name", data.getName());
        values.put("detail", data.getDetail());
        values.put("time", data.getTime());
        values.put("other", data.getOther());
        return values;
    }
}
