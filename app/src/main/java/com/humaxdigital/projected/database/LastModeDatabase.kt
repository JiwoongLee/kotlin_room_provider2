package com.humaxdigital.projected.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(LastModeEntity::class), version = 1)
abstract class LastModeDatabase : RoomDatabase() {


    abstract fun lastModeDao(): LastModeDAO

    companion object {

        private val TAG = LastModeDatabase::class.java.simpleName

        @Volatile
        private var sInstance: LastModeDatabase? = null

        @Synchronized
        fun getInstance(context: Context?): LastModeDatabase? {

            if (sInstance == null) {
                if (null != context) {
                    Log.d(TAG, "getInstance Room.databaseBuilder")
                    sInstance = Room.databaseBuilder(context.applicationContext,
                        LastModeDatabase::class.java, "projected_device_db")
                        .build()
                }
                else {
                    Log.d(TAG, "context is null")
                }
            }
            else {
                Log.d(TAG, "instance not null")
            }
            return sInstance
        }
    }
}