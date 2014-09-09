package com.skycopyhot.fitnesshelper.core;

import android.content.Context;

/**
 * Created by skycopyhot on 6/9/14.
 */
public class CoreHelper {

    private static CoreManager mManager;

    public static void init(Context context) {
        mManager = new CoreManager(context);
    }

    public static boolean queryAllGlobalData(ICoreCallback callback) {
        if (mManager == null) {
            return false;
        }

        return true;
    }
}
