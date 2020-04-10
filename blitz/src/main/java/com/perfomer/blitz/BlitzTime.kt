package com.perfomer.blitz

import androidx.annotation.StringRes

private const val SECOND_MILLIS = 1000L
private const val MINUTE_MILLIS = 60L * SECOND_MILLIS
private const val HOUR_MILLIS = 60L * MINUTE_MILLIS
private const val DAY_MILLIS = 24L * HOUR_MILLIS
private const val WEEK_MILLIS = 7L * DAY_MILLIS
private const val MONTH_MILLIS = 4L * WEEK_MILLIS
private const val YEAR_MILLIS = 12L * MONTH_MILLIS

internal enum class BlitzTime(
    val dividerMs: Long? = null,
    val differenceMs: Long,
    val updateRateMs: Long,
    @StringRes val textResource: Int
) {

    FUTURE(
        differenceMs = 0L,
        updateRateMs = 5L * SECOND_MILLIS,
        textResource = R.string.blitz_future
    ),

    SECONDS(
        dividerMs = SECOND_MILLIS,
        differenceMs = MINUTE_MILLIS,
        updateRateMs = SECOND_MILLIS,
        textResource = R.string.blitz_seconds
    ),

    MINUTE(
        differenceMs = 2L * MINUTE_MILLIS,
        updateRateMs = 30L * SECOND_MILLIS,
        textResource = R.string.blitz_minute
    ),

    MINUTES(
        dividerMs = MINUTE_MILLIS,
        differenceMs = HOUR_MILLIS,
        updateRateMs = MINUTE_MILLIS,
        textResource = R.string.blitz_minutes
    ),

    HOUR(
        differenceMs = 2L * HOUR_MILLIS,
        updateRateMs = 30L * MINUTE_MILLIS,
        textResource = R.string.blitz_hour
    ),

    HOURS(
        dividerMs = HOUR_MILLIS,
        differenceMs = DAY_MILLIS,
        updateRateMs = HOUR_MILLIS,
        textResource = R.string.blitz_hours
    ),

    DAY(
        differenceMs = 2L * DAY_MILLIS,
        updateRateMs = 12L * HOUR_MILLIS,
        textResource = R.string.blitz_day
    ),

    DAYS(
        dividerMs = DAY_MILLIS,
        differenceMs = WEEK_MILLIS,
        updateRateMs = DAY_MILLIS,
        textResource = R.string.blitz_days
    ),

    WEEK(
        differenceMs = 2L * WEEK_MILLIS,
        updateRateMs = 4 * DAY_MILLIS,
        textResource = R.string.blitz_week
    ),

    WEEKS(
        dividerMs = WEEK_MILLIS,
        differenceMs = MONTH_MILLIS,
        updateRateMs = WEEK_MILLIS,
        textResource = R.string.blitz_weeks
    ),

    MONTH(
        differenceMs = 2L * MONTH_MILLIS,
        updateRateMs = 2 * WEEK_MILLIS,
        textResource = R.string.blitz_month
    ),

    MONTHS(
        dividerMs = MONTH_MILLIS,
        differenceMs = YEAR_MILLIS,
        updateRateMs = MONTH_MILLIS,
        textResource = R.string.blitz_months
    ),

    YEAR(
        differenceMs = 2L * YEAR_MILLIS,
        updateRateMs = 6 * MONTH_MILLIS,
        textResource = R.string.blitz_year
    ),

    YEARS(
        dividerMs = YEAR_MILLIS,
        differenceMs = -1,
        updateRateMs = YEAR_MILLIS,
        textResource = R.string.blitz_years
    )

}