package com.humaxdigital.projected.database

import android.content.*
import android.database.Cursor
import android.net.Uri
import android.util.Log

private const val DBNAME = "projected_device_db"

class LastModeManager : ContentProvider() {

    companion object {
        private val TAG = LastModeManager::class.java.simpleName

        private const val AUTHORITY = "yandex.auto.projected"
        const val TASK_LASTMODE = "lastmode"

        private lateinit var mContext: Context

        private const val MATCH_CODE_1 = 1
        private const val MATCH_CODE_2 = 2

        private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, LastModeEntity.TABLE_NAME, MATCH_CODE_1)
            addURI(AUTHORITY, "${LastModeEntity.TABLE_NAME}/#", MATCH_CODE_2)
        }

        //val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/${LastModeEntity.TABLE_NAME}")
    }

    private lateinit var lastModeDao: LastModeDAO

    fun initialize() {
        Log.d(TAG, "initialize")
        mContext = context!!
        lastModeDao = LastModeDatabase.getInstance(mContext)!!.lastModeDao()
    }

    override fun onCreate(): Boolean {
        Log.d(TAG, "onCreate creating a lastmode database")
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {

        val cursor: Cursor?

        when (sUriMatcher.match(uri)) {
            1 -> {
                Log.d(TAG, "matched with code 1")
                cursor = lastModeDao.selectAll()
            }
            2 -> {
                Log.d(TAG, "matched with code 2")
                cursor = lastModeDao.selectById(ContentUris.parseId(uri))
            }
            else -> {
                throw IllegalArgumentException("Unknown URI on query: $uri")
            }
        }

        cursor.setNotificationUri(context?.contentResolver, uri)
        return cursor
    }

    override fun getType(p0: Uri): String? {

        when (sUriMatcher.match(p0)) {
            MATCH_CODE_1 -> {
                return "vnd.android.cursor.dir/$AUTHORITY/$TASK_LASTMODE"
            }
            MATCH_CODE_2 -> {
                return "vnd.android.cursor.item/$AUTHORITY/$TASK_LASTMODE"
            }
            else -> {
                throw IllegalArgumentException("Unknown URI on getType: $p0")
            }
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        if (sUriMatcher.match(uri) != 1) {
            throw IllegalArgumentException("Unknown URI on insert: $uri")
        }
        //need to add
        when (sUriMatcher.match(uri)) {
            1 -> {
                val id: Long = lastModeDao.insert(LastModeEntity.fromContentValues(values))
                context?.contentResolver?.notifyChange(uri, null)
                return ContentUris.withAppendedId(uri, id)
            }
            2 -> {
                throw IllegalArgumentException("Invalid URI, cannot insert with ID: $uri")
            }
            else -> {
                throw IllegalArgumentException("Unknown URI on insert: $uri")
            }
        }
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {

        when (sUriMatcher.match(uri)) {
            MATCH_CODE_1 -> {
                Log.d(TAG, "delete whole table")
            }
            MATCH_CODE_2 -> {
                return lastModeDao.deleteById(ContentUris.parseId(uri))
            }
            else -> {
                throw IllegalArgumentException("Unknown URI on delete: $uri match_code: ${sUriMatcher.match(uri)}")
            }
        }
        val itemDeleted: Int = lastModeDao.deleteAll()
        mContext.contentResolver.notifyChange(uri, null)
        return itemDeleted
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {

        val count: Int

        when (sUriMatcher.match(uri)) {
            MATCH_CODE_1 -> {
                val entity = LastModeEntity.fromContentValues(values)
                entity.id = ContentUris.parseId(uri)
                count = lastModeDao.update(entity)
            }
            else -> {
                throw IllegalArgumentException("Unknown URI on update: $uri")
            }
        }

        mContext.contentResolver.notifyChange(uri, null)
        return count
    }
}