package com.ayoubelkhatab.android_ktx

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * formats a date into string using the provided [pattern]
 */
@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.formatToString(pattern: String, locale: Locale = Locale.US): String {
    val formatter = DateTimeFormatter.ofPattern(pattern, locale)
    return formatter.format(this)
}

/**
 * accepts only either dd-mm-yyyy or mm-dd-yyy
 * delimiter between day and month and year can be anything
 */
@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.fromString(
    date: String,
    delimiter: Char,
    dayMonthYear: Boolean = true
): LocalDate? {
    if (date.contains(delimiter)) {
        val dateList = date.split(delimiter)
        return if (dayMonthYear) {
            LocalDate.of(
                dateList[2].toInt(),
                dateList[1].toInt(),
                dateList.first().toInt(),
            )
        } else {
            LocalDate.of(
                dateList[2].toInt(),
                dateList.first().toInt(),
                dateList[1].toInt(),
            )
        }
    }
    return null
}