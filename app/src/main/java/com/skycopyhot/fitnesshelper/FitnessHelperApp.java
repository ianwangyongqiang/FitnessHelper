package com.skycopyhot.fitnesshelper;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.skycopyhot.fitnesshelper.core.CoreHelper;

/**
 * Created by skycopyhot on 4/9/14.
 */
public class FitnessHelperApp extends Application implements Handler.Callback{

    private static final String FITNESS_BG_THREAD = "fitness_bg_thread";
    private Handler mUIHandler;
    private Handler mBGHandler;

    private boolean mInitialized = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mUIHandler = new Handler(getMainLooper(), this);
        HandlerThread bgThread = new HandlerThread(FITNESS_BG_THREAD);
        bgThread.start();
        mBGHandler = new Handler(bgThread.getLooper(), this);
        CoreHelper.init(this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg != null && msg.obj instanceof TaskMessage) {
            ((TaskMessage) msg.obj).getCallback().onCallback(msg.what, null);
            return true;
        }

        if (msg != null) {
            msg.recycle();
        }
        return false;
    }

    public Handler getUIHandler() {
        return mUIHandler;
    }

    public Handler getBGHandler() {
        return mBGHandler;
    }

    public boolean isInitialized() {
        return mInitialized;
    }

    public void startInitilize() {
        mInitialized = true;
    }
}
