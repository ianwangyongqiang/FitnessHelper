package com.skycopyhot.fitnesshelper;

import android.app.Application;
import android.os.Handler;
import android.os.Message;

/**
 * Created by skycopyhot on 4/9/14.
 */
public class FitnessHelperApp extends Application implements Handler.Callback{

    private static final String FITNESS_UI_THREAD = "fitness_ui_thread";
    private Handler mUIHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        mUIHandler = new Handler(getMainLooper(), this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg != null && msg.obj instanceof TaskMessage) {
            ((TaskMessage) msg.obj).getCallback().onCallback(msg.what, null);
            return true;
        }
        return false;
    }

    public Handler getUIHandler() {
        return mUIHandler;
    }
}
