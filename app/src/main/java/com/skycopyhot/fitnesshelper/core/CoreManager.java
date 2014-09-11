package com.skycopyhot.fitnesshelper.core;

import android.content.Context;
import android.os.Bundle;

import com.skycopyhot.fitnesshelper.core.db.GlobalDB;
import com.skycopyhot.fitnesshelper.core.db.PushUpDB;
import com.skycopyhot.fitnesshelper.core.model.GlobalData;
import com.skycopyhot.fitnesshelper.core.model.PushUpData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skycopyhot on 9/9/14.
 */
public class CoreManager implements IBundleConstant {

    private GlobalDB mGlobalDB;
    private PushUpDB mPushUpDB;


    public CoreManager(Context context) {
        mGlobalDB = new GlobalDB(context);
        mPushUpDB = new PushUpDB(context);
    }

    public void queryData(Bundle bundle, ICoreDataCallback callback) {
        String sheet = bundle.getString(KEY_SHEET);
        if (VALUE_SHEET_GLOBAL.equals(sheet)) {
            List<GlobalData> result = mGlobalDB.queryAll();
            ArrayList<String> names = new ArrayList<String>();
            ArrayList<Long> times = new ArrayList<Long>();
            ArrayList<Integer> details = new ArrayList<Integer>();
            ArrayList<String> others = new ArrayList<String>();
            for (GlobalData data : result) {
                names.add(data.getName());
                details.add(data.getDetail());
                times.add(data.getTime());
                others.add(data.getOther());
            }
            DataWrapper wrapper = new DataWrapper();
            wrapper.setStrings(ICoreDataCallback.KEY_ARRAY_STRING + ICoreDataCallback.KEY_NAME, names);
            wrapper.setLongs(ICoreCallback.KEY_ARRAY_LONG + ICoreCallback.KEY_TIME, times);
            wrapper.setIntegers(ICoreCallback.KEY_ARRAY_INTEGER + ICoreCallback.KEY_DETAIL, details);
            wrapper.setStrings(ICoreCallback.KEY_ARRAY_STRING + ICoreCallback.KEY_OTHER, others);
            callback.onCoreDataCallback(ICoreCallback.RESULT_CODE_SUCCESS, wrapper);
        } else if (VALUE_SHEET_PUSH_UP.equals(sheet)) {
            List<PushUpData> result = mPushUpDB.queryAll();
            ArrayList<String> others = new ArrayList<String>();
            ArrayList<Long> starts = new ArrayList<Long>();
            ArrayList<Long> ends = new ArrayList<Long>();
            ArrayList<Integer> counts = new ArrayList<Integer>();
            ArrayList<Integer> types = new ArrayList<Integer>();
            for (PushUpData data : result) {
                others.add(data.getOther());
                starts.add(data.getStartTime());
                ends.add(data.getEndTime());
                counts.add(data.getCount());
                types.add(data.getCount());
            }
            DataWrapper wrapper = new DataWrapper();
            wrapper.setStrings(ICoreCallback.KEY_ARRAY_STRING + ICoreCallback.KEY_OTHER, others);
            wrapper.setLongs(ICoreCallback.KEY_ARRAY_LONG + ICoreCallback.KEY_START, starts);
            wrapper.setLongs(ICoreCallback.KEY_ARRAY_LONG + ICoreCallback.KEY_END, ends);
            wrapper.setIntegers(ICoreCallback.KEY_ARRAY_INTEGER + ICoreCallback.KEY_COUNT, counts);
            wrapper.setIntegers(ICoreCallback.KEY_ARRAY_INTEGER + ICoreCallback.KEY_TYPE, types);
            callback.onCoreDataCallback(ICoreCallback.RESULT_CODE_SUCCESS, wrapper);
        } else {
            callback.onCoreDataCallback(ICoreCallback.RESULT_CODE_FAILURE_OTHER, null);
        }
    }
}
