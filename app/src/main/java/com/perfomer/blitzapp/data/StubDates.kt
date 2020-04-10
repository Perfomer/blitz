package com.perfomer.blitzapp.data

import java.util.*

val DATES = listOf(
    createDate(),
    createDate(minusSecond = 30),
    createDate(minusMinute = 1),
    createDate(minusMinute = 30),
    createDate(minusHour = 1),
    createDate(minusHour = 12),
    createDate(minusDay = 1),
    createDate(minusDay = 2),
    createDate(minusDay = 7),
    createDate(minusDay = 23),
    createDate(minusMonth = 1),
    createDate(minusMonth = 5),
    createDate(minusYear = 1),
    createDate(minusYear = 10)
)

private fun createDate(
    minusYear: Int? = null,
    minusMonth: Int? = null,
    minusDay: Int? = null,
    minusHour: Int? = null,
    minusMinute: Int? = null,
    minusSecond: Int? = null
): Date {
    val calendar = Calendar.getInstance().apply {
        minusYear?.let { add(Calendar.YEAR, -it) }
        minusMonth?.let { add(Calendar.MONTH, -it) }
        minusDay?.let { add(Calendar.DAY_OF_MONTH, -it) }
        minusHour?.let { add(Calendar.HOUR_OF_DAY, -it) }
        minusMinute?.let { add(Calendar.MINUTE, -it) }
        minusSecond?.let { add(Calendar.SECOND, -it) }
    }

    return calendar.time
}