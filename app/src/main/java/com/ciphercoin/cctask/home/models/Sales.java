package com.ciphercoin.cctask.home.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by satya on 25-Nov-17.
 */

public class Sales {
    @SerializedName("today")
    private String today;
    @SerializedName("current_month")
    private String current_month;
    @SerializedName("totals")
    private String totals;
    @SerializedName("last_month")
    private String last_month;

    public String getToday() {
        return today;
    }

    public String getCurrent_month() {
        return current_month;
    }

    public String getTotals() {
        return totals;
    }

    public String getLast_month() {
        return last_month;
    }
}