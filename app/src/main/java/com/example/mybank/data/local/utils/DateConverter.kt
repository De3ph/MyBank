package com.example.mybank.data.local.utils

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    companion object {
        fun dateToTrString(date: Date): String {
            return SimpleDateFormat("DD/MM HH:MM", Locale.forLanguageTag("tr")).format(date)
        }
    }
}