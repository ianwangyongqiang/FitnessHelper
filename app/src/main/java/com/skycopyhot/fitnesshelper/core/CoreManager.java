package com.skycopyhot.fitnesshelper.core;

import android.content.Context;
import android.os.Bundle;

import com.skycopyhot.fitnesshelper.core.db.GlobalDB;
import com.skycopyhot.fitnesshelper.core.db.PushUpDB;
import com.skycopyhot.fitnesshelper.core.model.GlobalData;

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

    public boolean queryData(Bundle bundle, ICoreDataCallback callback) {
        String sheet = bundle.getString(KEY_SHEET);
        if (VALUE_SHEET_GLOBAL.equals(sheet)) {
            List<GlobalData> datas = mGlobalDB.queryAll();
            ArrayList<String> names = new ArrayList<String>();
            ArrayList<Long> times = new ArrayList<Long>();
            ArrayList<Integer> details = new ArrayList<Integer>();
            ArrayList<String> others = new ArrayList<String>();
            for (GlobalData data : datas) {
                names.add(data.getName());
                details.add(data.getDetail());
                times.add(data.getTime());
                others.add(data.getOther());
            }
            Bundle result = new Bundle();
            result.putStringArrayList(ICoreDataCallback.KEY_ARRAY_STRING + ICoreDataCallback.KEY_NAME, names);
            return true;
        } else if (VALUE_SHEET_PUSH_UP.equals(sheet)) {


            
            return true;
        } else {
            return false;
        }
    }
}
