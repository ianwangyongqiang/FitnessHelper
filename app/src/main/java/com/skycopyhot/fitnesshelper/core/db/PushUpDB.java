package com.skycopyhot.fitnesshelper.core.db;

import android.content.Context;

import com.skycopyhot.fitnesshelper.core.model.PushUpData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skycopyhot on 7/9/14.
 */
public class PushUpDB extends BaseDB {

    public PushUpDB(Context context) {
        super(context);
    }

    public List<PushUpData> queryAll() {
        List<PushUpData> result = new ArrayList<PushUpData>();

        return result;
    }
}
