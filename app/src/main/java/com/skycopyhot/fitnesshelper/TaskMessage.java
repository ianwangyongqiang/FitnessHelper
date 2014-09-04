package com.skycopyhot.fitnesshelper;

/**
 * Created by skycopyhot on 4/9/14.
 */
public class TaskMessage {
    private IBaseCallback mCallback;
    private int mId;

    public TaskMessage(int id, IBaseCallback callback) {
        mCallback = callback;
        mId = id;
    }

    public int getId() {
        return mId;
    }

    public IBaseCallback getCallback() {
        return mCallback;
    }
}
