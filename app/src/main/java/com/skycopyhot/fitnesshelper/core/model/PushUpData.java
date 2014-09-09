package com.skycopyhot.fitnesshelper.core.model;

/**
 * Created by skycopyhot on 8/9/14.
 */
public class PushUpData {
    private String other;
    private long start;
    private long end;
    private int count;
    private int type;

    public PushUpData(String other, String start, String end, int count, int type) {
        this.other = other;
        this.start = Long.parseLong(start);
        this.end = Long.parseLong(end);
        this.count = count;
        this.type = type;
    }

    public String getOther() {
        return other;
    }

    public long getStartTime() {
        return start;
    }

    public long getEndTime() {
        return end;
    }

    public int getCount() {
        return count;
    }

    public int getType() {
        return type;
    }
}
