package com.humaxdigital.projected

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.humaxdigital.projected.database.LastModeManager

class LastModeActivity: Activity() {

    private val TAG = LastModeActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate")
        LastModeManager().initialize()
    }
}