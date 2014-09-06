package com.skycopyhot.fitnesshelper.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skycopyhot.fitnesshelper.BaseActivity;
import com.skycopyhot.fitnesshelper.FitnessHelperApp;
import com.skycopyhot.fitnesshelper.IUICallback;
import com.skycopyhot.fitnesshelper.R;
import com.skycopyhot.fitnesshelper.TaskMessage;


public class MainActivity extends BaseActivity implements IUICallback{

    private static TextView mText;
    private static final int ID_CHANGE_TEXT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        post(new TaskMessage(ID_CHANGE_TEXT, this), 5000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void onCallback(int id, Bundle bundle) {
        if (id == ID_CHANGE_TEXT) {
            mText.setText(R.string.action_settings);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            mText = (TextView) rootView.findViewById(R.id.main_text);
            return rootView;
        }
    }
}
