package com.perfomer.blitz

import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

/*
 * Designed and developed by 2020 Perfomer (Denis Balchugov)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    @PluralsRes val pluralResource: Int? = null,
    @StringRes val singleStringResource: Int? = null
) {

    FUTURE(
        differenceMs = 0L,
        updateRateMs = 5L * SECOND_MILLIS,
        singleStringResource = R.string.blitz_future
    ),

    SECONDS(
        dividerMs = SECOND_MILLIS,
        differenceMs = MINUTE_MILLIS,
        updateRateMs = SECOND_MILLIS,
        pluralResource = R.plurals.blitz_seconds
    ),

    MINUTE(
        differenceMs = 2L * MINUTE_MILLIS,
        updateRateMs = 30L * SECOND_MILLIS,
        singleStringResource = R.string.blitz_single_minute
    ),

    MINUTES(
        dividerMs = MINUTE_MILLIS,
        differenceMs = HOUR_MILLIS,
        updateRateMs = MINUTE_MILLIS,
        pluralResource = R.plurals.blitz_minutes
    ),

    HOUR(
        differenceMs = 2L * HOUR_MILLIS,
        updateRateMs = 30L * MINUTE_MILLIS,
        singleStringResource = R.string.blitz_single_hour
    ),

    HOURS(
        dividerMs = HOUR_MILLIS,
        differenceMs = DAY_MILLIS,
        updateRateMs = HOUR_MILLIS,
        pluralResource = R.plurals.blitz_hours
    ),

    DAY(
        differenceMs = 2L * DAY_MILLIS,
        updateRateMs = 12L * HOUR_MILLIS,
        singleStringResource = R.string.blitz_single_day
    ),

    DAYS(
        dividerMs = DAY_MILLIS,
        differenceMs = WEEK_MILLIS,
        updateRateMs = DAY_MILLIS,
        pluralResource = R.plurals.blitz_days
    ),

    WEEK(
        differenceMs = 2L * WEEK_MILLIS,
        updateRateMs = 4 * DAY_MILLIS,
        singleStringResource = R.string.blitz_single_week
    ),

    WEEKS(
        dividerMs = WEEK_MILLIS,
        differenceMs = MONTH_MILLIS,
        updateRateMs = WEEK_MILLIS,
        pluralResource = R.plurals.blitz_weeks
    ),

    MONTH(
        differenceMs = 2L * MONTH_MILLIS,
        updateRateMs = 2 * WEEK_MILLIS,
        singleStringResource = R.string.blitz_single_month
    ),

    MONTHS(
        dividerMs = MONTH_MILLIS,
        differenceMs = YEAR_MILLIS,
        updateRateMs = MONTH_MILLIS,
        pluralResource = R.plurals.blitz_months
    ),

    YEAR(
        differenceMs = 2L * YEAR_MILLIS,
        updateRateMs = 6 * MONTH_MILLIS,
        singleStringResource = R.string.blitz_single_year
    ),

    YEARS(
        dividerMs = YEAR_MILLIS,
        differenceMs = -1,
        updateRateMs = YEAR_MILLIS,
        pluralResource = R.plurals.blitz_years
    )

}