package com.skycopyhot.fitnesshelper.core;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by skycopyhot on 6/9/14.
 */
public class CoreHelper {

    private static CoreManager mManager;

    /**
     * initialize the core resource
     * @param context
     */
    public static void init(Context context) {
        mManager = new CoreManager(context);
    }

    /**
     * get all global data
     * @param callback
     */
    public static void getAllGlobalData(ICoreDataCallback callback) {
        getGlobalData(0, IBundleConstant.VALUE_SIZE_ALL, callback);
    }

    /**
     * get the special global data
     * @param from
     * @param size
     * @param callback
     */
    public static void getGlobalData(int from, int size, ICoreDataCallback callback) {
        if (mManager == null) {
            callback.onCoreDataCallback(ICoreCallback.RESULT_CODE_FAILURE_OTHER, null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(IBundleConstant.KEY_SHEET, IBundleConstant.VALUE_SHEET_GLOBAL);
            bundle.putInt(IBundleConstant.KEY_FROM, from);
            bundle.putInt(IBundleConstant.KEY_SIZE, size);
            mManager.getData(bundle, callback);
        }
    }

}
