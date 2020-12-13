package com.example.asystentnayczyciela.Model.Converters

import androidx.room.TypeConverter
import java.util.*

public class DateConverter {
    @TypeConverter
    public fun toDate(timestamp : Long?) : Date?
    {
        return timestamp?.let { Date(it) };
    }

    @TypeConverter
    public fun fromDate(date: Date?): Long? {
        return date?.time;
    }
}