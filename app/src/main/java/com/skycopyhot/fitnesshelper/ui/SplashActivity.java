package com.skycopyhot.fitnesshelper.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.skycopyhot.fitnesshelper.BaseActivity;
import com.skycopyhot.fitnesshelper.FitnessHelperApp;
import com.skycopyhot.fitnesshelper.IUICallback;
import com.skycopyhot.fitnesshelper.R;
import com.skycopyhot.fitnesshelper.TaskMessage;

public class SplashActivity extends BaseActivity implements IUICallback{

    private static final int ID_JUMP = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ((FitnessHelperApp) getApplication()).startInitilize();
        post(new TaskMessage(ID_JUMP, this), 5000);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onCallback(int id, Bundle bundle) {
        if (id == ID_JUMP) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}
