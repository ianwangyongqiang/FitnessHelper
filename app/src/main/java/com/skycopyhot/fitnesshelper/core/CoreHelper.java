package com.skycopyhot.fitnesshelper.core;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by skycopyhot on 6/9/14.
 */
public class CoreHelper {

    private static CoreManager mManager;

    public static void init(Context context) {
        mManager = new CoreManager(context);
    }

    public static void queryAllGlobalData(ICoreDataCallback callback) {
        if (mManager == null) {
            callback.onCoreDataCallback(ICoreCallback.RESULT_CODE_FAILURE_OTHER, null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(IBundleConstant.KEY_SHEET, IBundleConstant.VALUE_SHEET_GLOBAL);
            mManager.queryData(bundle, callback);
        }
    }
}
