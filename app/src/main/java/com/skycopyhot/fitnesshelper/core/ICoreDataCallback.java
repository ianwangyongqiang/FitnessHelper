package com.skycopyhot.fitnesshelper.core;

import android.os.Bundle;

/**
 * Created by skycopyhot
 * 9/9/14
 */
public interface ICoreDataCallback extends ICoreCallback {

    /**
     * call back from core
     * @param resultCode
     * @param bundle
     */
    public void onCoreDataCallback(int resultCode, Bundle bundle);
}
