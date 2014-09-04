package com.skycopyhot.fitnesshelper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;


public abstract class BaseActivity extends Activity {

    private FitnessHelperApp mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = (FitnessHelperApp) getApplication();
    }

    public void post(TaskMessage taskMsg) {
        post(taskMsg, 0);
    }

    public void post(TaskMessage taskMsg, long delay) {
        Message message = null;
        if (taskMsg.getCallback() instanceof IUICallback) {
            message = mApp.getUIHandler().obtainMessage();
        } else if (taskMsg.getCallback() instanceof IBGCallback) {
            message = mApp.getBGHandler().obtainMessage();
        }
        if (message != null) {
            message.what = taskMsg.getId();
            message.obj =taskMsg;
            mApp.getUIHandler().sendMessageDelayed(message, delay);
        }
    }
}
