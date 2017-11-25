package com.ciphercoin.cctask.home.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by satya on 25-Nov-17.
 */

public class Stats
{
    @SerializedName("earnings")
    private Earnings earnings;

    @SerializedName("sales")
    private Sales sales;

    public Earnings getEarnings ()
    {
        return earnings;
    }


    public Sales getSales ()
    {
        return sales;
    }

}


