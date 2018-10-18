package com.playground.nutrition.data.db;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by emil.ivanov on 10/17/18.
 */
class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

}
