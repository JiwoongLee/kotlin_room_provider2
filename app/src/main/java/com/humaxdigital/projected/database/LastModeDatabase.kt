package com.humaxdigital.projected.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(LastModeEntity::class), version = 1)
abstract class LastModeDatabase : RoomDatabase() {

    abstract fun lastModeDao(): LastModeDAO

    companion object {

        @Volatile
        private var sInstance: LastModeDatabase? = null

        @Synchronized
        fun getInstance(context: Context): LastModeDatabase? {

            if (sInstance == null) {
                sInstance = Room.databaseBuilder(context.applicationContext,
                    LastModeDatabase::class.java, "projected_device_db")
                    .build()
            }
            return sInstance
        }
    }
}