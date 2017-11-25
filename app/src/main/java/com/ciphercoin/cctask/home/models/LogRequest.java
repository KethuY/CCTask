package com.ciphercoin.cctask.home.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by satya on 25-Nov-17.
 */

public class LogRequest {
    @SerializedName("override")
    private String override;
    @SerializedName("log_requests")
    private String log_requests;
    @SerializedName("user_id")
    private String user_id;

    public String getOverride ()
    {
        return override;
    }

    public String getLog_requests ()
    {
        return log_requests;
    }

    public String getUser_id ()
    {
        return user_id;
    }

}
