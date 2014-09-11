package com.skycopyhot.fitnesshelper.core;

/**
 * Created by skycopyhot on 9/9/14.
 */
public interface ICoreCallback {

    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int RESULT_CODE_FAILURE_NO_NETWORK = 1;
    public static final int RESULT_CODE_FAILURE_OTHER = 2;

    public static final String KEY_ARRAY_STRING = "KEY_ARRAY_STRING";
    public static final String KEY_ARRAY_INTEGER = "KEY_ARRAY_INTEGER";
    public static final String KEY_ARRAY_LONG = "KEY_ARRAY_LONG";
    public static final String KEY_NAME = "_NAME";
    public static final String KEY_TIME = "_TIME";
    public static final String KEY_DETAIL = "_DETAIL";
    public static final String KEY_OTHER = "_OTHER";
    public static final String KEY_START = "_START";
    public static final String KEY_END = "_END";
    public static final String KEY_COUNT = "_COUNT";
    public static final String KEY_TYPE = "_TYPE";
}
