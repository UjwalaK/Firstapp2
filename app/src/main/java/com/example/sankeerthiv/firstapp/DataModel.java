package com.example.sankeerthiv.firstapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ukinih on 19-07-2018.
 */

public class DataModel {

    @SerializedName("status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
