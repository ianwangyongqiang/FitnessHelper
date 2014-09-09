package com.skycopyhot.fitnesshelper.core.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.skycopyhot.fitnesshelper.core.model.PushUpData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skycopyhot on 7/9/14.
 */
public class PushUpDB extends BaseDB {

    public PushUpDB(Context context) {
        super(context);
    }

    /**
     * query all push up data
     * @return
     */
    public List<PushUpData> queryAll() {
        List<PushUpData> result = new ArrayList<PushUpData>();
        synchronized (FitnessDBHelper.SYNC_OBJ) {
            SQLiteDatabase db = mHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + SHEET_NAME_PUSH_UP, null);
            if (db != null && cursor != null) {
                try {
                    while (cursor.moveToNext()) {
                        String other = cursor.getString(cursor.getColumnIndex("other"));
                        String start = cursor.getString(cursor.getColumnIndex("start"));
                        String end = cursor.getString(cursor.getColumnIndex("end"));
                        int count = cursor.getInt(cursor.getColumnIndex("count"));
                        int type = cursor.getInt(cursor.getColumnIndex("type"));
                        PushUpData data = new PushUpData(other, start, end, count, type);
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

    /**
     * insert the push up data
     * @param data
     * @return location of the data, if it returns 0, something goes wrong
     */
    public long insertPushUpData(PushUpData data) {
        if (data == null) {
            return 0;
        }
        long result = 0;
        synchronized (FitnessDBHelper.SYNC_OBJ) {
            SQLiteDatabase db = mHelper.getWritableDatabase();
            result = db.insert(SHEET_NAME_PUSH_UP, null, getValues(data));
        }
        return 0;
    }

    private ContentValues getValues(PushUpData data) {
        ContentValues values = new ContentValues();
        values.put("other", data.getOther());
        values.put("start", String.valueOf(data.getStartTime()));
        values.put("end", String.valueOf(data.getEndTime()));
        values.put("count", data.getCount());
        values.put("type", data.getType());
        return values;
    }
}
