package com.ciphercoin.cctask.home.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by satya on 25-Nov-17.
 */

public class SalesReport {
    @SerializedName("0")
    private LogRequest logRequest;
    @SerializedName("stats")
    private Stats stats;
    @SerializedName("request_speed")
    private String request_speed;

    public Stats getStats() {
        return stats;
    }
    public LogRequest getLogRequest() {
        return logRequest;
    }
    public String getRequest_speed() {
        return request_speed;
    }
}