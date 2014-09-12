package com.skycopyhot.fitnesshelper.core.model;

/**
 * Created by skycopyhot on 7/9/14.
 */
public class GlobalData {

    private int from;
    private long time;
    private String name;
    private int detail;
    private String other;

    public GlobalData(int from, String name, String time, int detail, String other) {
        this.from = from;
        this.name = name;
        this.time = Long.parseLong(time);
        this.detail = detail;
        this.other = other;
    }

    public long getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public int getDetail() {
        return detail;
    }

    public String getOther() {
        return other;
    }

    public int getFrom() {
        return from;
    }
}
