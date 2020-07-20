package com.humaxdigital.projected

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

import com.humaxdigital.projected.database.LastModeManager

class LastModeService : JobIntentService() {

    private val TAG = LastModeService::class.java.simpleName
    companion object {
        private const val JOB_ID = 0x1001

        fun enqueueWork(content: Context, work: Intent) {
            enqueueWork(content, LastModeService::class.java, JOB_ID, work)
        }
    }

    override fun onHandleWork(intent: Intent) {
        Log.d(TAG, "onHandleWork")
        //LastModeManager().initialize()
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}