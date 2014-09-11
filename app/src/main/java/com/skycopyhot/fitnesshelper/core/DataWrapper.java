package com.skycopyhot.fitnesshelper.core;

import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by skycopyhot
 * 11/9/14
 */
public class DataWrapper {

    private Bundle mBundle;
    private ArrayList<Long> mLongList = new ArrayList<Long>();

    public DataWrapper() {
        mBundle = new Bundle();
    }

    public ArrayList<String> getStrings(String key) {
        return mBundle.getStringArrayList(key);
    }

    public ArrayList<Integer> getIntegers(String key) {
        return mBundle.getIntegerArrayList(key);
    }

    public ArrayList<Long> getLongs(String key) {
        return mLongList;
    }

    public void setStrings(String key, ArrayList<String> data) {
        mBundle.putStringArrayList(key, data);
    }

    public void setString(String key, String data) {
        mBundle.putString(key, data);
    }

    public void setIntegers(String key, ArrayList<Integer> data) {
        mBundle.putIntegerArrayList(key, data);
    }

    public void setInteger(String key, int data) {
        mBundle.putInt(key, data);
    }

    public void setLongs(String key, ArrayList<Long> data) {
        mLongList.clear();
        mLongList.addAll(data);
    }

    public void setLong(String key, long data) {
        mBundle.putLong(key, data);
    }

}
