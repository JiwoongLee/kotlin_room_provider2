package com.humaxdigital.projected.database

import android.database.Cursor
import android.provider.BaseColumns
import androidx.room.*

@Dao
interface LastModeDAO {

    @Query("SELECT * FROM ${LastModeEntity.TABLE_NAME} ORDER BY ${BaseColumns._ID} ASC")
    fun selectAll(): Cursor

    @Query("SELECT * FROM ${LastModeEntity.TABLE_NAME} WHERE ${BaseColumns._ID} = :id")
    fun selectById(id: Long): Cursor

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: LastModeEntity): Long

    @Query("DELETE FROM ${LastModeEntity.TABLE_NAME}")
    fun deleteAll(): Int

    @Query("DELETE FROM ${LastModeEntity.TABLE_NAME} WHERE ${BaseColumns._ID} = :id")
    fun deleteById(id: Long): Int

    @Update
    fun update(entity: LastModeEntity): Int
}