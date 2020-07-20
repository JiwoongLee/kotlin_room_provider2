package com.humaxdigital.projected.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.humaxdigital.projected.LastModeService

class BootCompleteReceiver : BroadcastReceiver() {

    companion object {
        private val TAG = BootCompleteReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (null != action?.equals(Intent.ACTION_BOOT_COMPLETED)) {
            LastModeService.enqueueWork(context, Intent())
        }

    }
}