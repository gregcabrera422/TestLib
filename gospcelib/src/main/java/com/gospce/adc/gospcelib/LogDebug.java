package com.gospce.adc.gospcelib;

import android.util.Log;

public class LogDebug {
    private static final String TAG = "GoSPCE";

    public static void d(String message) {
        Log.d(TAG, message);
    }
}
