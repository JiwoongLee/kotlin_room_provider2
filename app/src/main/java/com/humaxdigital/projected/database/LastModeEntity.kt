package com.humaxdigital.projected.database

import android.content.ContentValues
import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = LastModeEntity.TABLE_NAME)
class LastModeEntity {

    companion object {
        const val TABLE_NAME = "device_list"

        const val COLUMN_ID: String = BaseColumns._ID
        const val COLUMN_NAME: String = "name"
        const val COLUMN_DEVICE_ID: String ="device_id"
        const val COLUMN_SUPPORTED_SYSTEM: String = "supported_systems"
        const val COLUMN_AUTOSTART_SYSTEM: String = "autostart_system"
        const val COLUMN_IP_ADDRESS : String = "IP_ADDRESS"
        const val COLUMN_SCREEN_RES : String = "SCREEN_RES"
        const val COLUMN_AUDIO_RES : String = "AUDIO_RES"
        const val COLUMN_OP_STATUS : String = "OP_STATUS"
        const val COLUMN_OPT_1 : String = "OPT_1"
        const val COLUMN_IF_TYPE : String = "IF_TYPE"
        const val COLUMN_CARPLAY_SUPPORT : String = "CP_SUPPRT"
        const val COLUMN_RESERVED_1: String = "REV_1"
        const val COLUMN_RESERVED_2: String = "REV_2"

        fun fromContentValues(values: ContentValues?): LastModeEntity {
            val entity = LastModeEntity()
            if (null != values?.containsKey(COLUMN_ID)) {
                entity.id = values.getAsLong(COLUMN_ID)
            }
            if (null != values?.containsKey(COLUMN_NAME)) {
                entity.name = values.getAsString(COLUMN_NAME)
            }
            if (null != values?.containsKey(COLUMN_DEVICE_ID)) {
                entity.device_id = values.getAsString(COLUMN_DEVICE_ID)
            }
            if (null != values?.containsKey(COLUMN_SUPPORTED_SYSTEM)) {
                entity.supported_system = values.getAsString(COLUMN_SUPPORTED_SYSTEM)
            }
            if (null != values?.containsKey(COLUMN_AUTOSTART_SYSTEM)) {
                entity.autostart_system = values.getAsString(COLUMN_AUTOSTART_SYSTEM)
            }
            if (null != values?.containsKey(COLUMN_IP_ADDRESS)) {
                entity.ip_addr = values.getAsString(COLUMN_IP_ADDRESS)
            }
            if (null != values?.containsKey(COLUMN_SCREEN_RES)) {
                entity.screen_res = values.getAsInteger(COLUMN_SCREEN_RES)
            }
            if (null != values?.containsKey(COLUMN_AUDIO_RES)) {
                entity.audio_res = values.getAsInteger(COLUMN_AUDIO_RES)
            }
            if (null != values?.containsKey(COLUMN_OP_STATUS)) {
                entity.op_status = values.getAsInteger(COLUMN_OP_STATUS)
            }
            if (null != values?.containsKey(COLUMN_OPT_1)) {
                entity.opt_1 = values.getAsInteger(COLUMN_OPT_1)
            }
            if (null != values?.containsKey(COLUMN_IF_TYPE)) {
                entity.if_type = values.getAsInteger(COLUMN_IF_TYPE)
            }
            if (null != values?.containsKey(COLUMN_CARPLAY_SUPPORT)) {
                entity.cp_support = values.getAsInteger(COLUMN_CARPLAY_SUPPORT)
            }
            if (null != values?.containsKey(COLUMN_RESERVED_1)) {
                entity.res_1 = values.getAsInteger(COLUMN_RESERVED_1)
            }
            if (null != values?.containsKey(COLUMN_RESERVED_2)) {
                entity.res_2 = values.getAsInteger(COLUMN_RESERVED_2)
            }
            return entity
        }
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    var id: Long = 0

    @ColumnInfo(name = COLUMN_NAME)
    var name: String = "none"

    @ColumnInfo(name = COLUMN_DEVICE_ID)
    var device_id: String = ""

    @ColumnInfo(name = COLUMN_SUPPORTED_SYSTEM)
    var supported_system: String = ""

    @ColumnInfo(name = COLUMN_AUTOSTART_SYSTEM)
    var autostart_system: String = ""

    @ColumnInfo(name = COLUMN_IP_ADDRESS)
    var ip_addr: String = ""

    @ColumnInfo(name = COLUMN_SCREEN_RES)
    var screen_res: Int = 0

    @ColumnInfo(name = COLUMN_AUDIO_RES)
    var audio_res: Int = 0

    @ColumnInfo(name = COLUMN_OP_STATUS)
    var op_status: Int = 0

    @ColumnInfo(name = COLUMN_OPT_1)
    var opt_1: Int = 0

    @ColumnInfo(name = COLUMN_IF_TYPE)
    var if_type: Int = 0

    @ColumnInfo(name = COLUMN_CARPLAY_SUPPORT)
    var cp_support: Int = 0

    @ColumnInfo(name = COLUMN_RESERVED_1)
    var res_1: Int = 0

    @ColumnInfo(name = COLUMN_RESERVED_2)
    var res_2: Int = 0


}