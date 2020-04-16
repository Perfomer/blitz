package com.perfomer.blitz

import android.content.Context
import android.content.res.Resources
import android.widget.TextView
import java.util.*

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

/**
 * Provides relative time [String]
 *
 * @receiver context.
 * @param date time of the event.
 * @param showSeconds **true** — show exact seconds count if time difference is less than minute;
 *                    **false** — shows "just now" message if time difference is less than minute.
 */
fun Context.getTimeAgo(date: Date, showSeconds: Boolean = false): String {
    return getTimeAgo(date.time, showSeconds)
}

/**
 * Provides relative time [String]
 *
 * @receiver context.
 * @param time time of the event (in millis).
 * @param showSeconds **true** — show exact seconds count if time difference is less than minute;
 *                    **false** — shows "just now" message if time difference is less than minute.
 */
fun Context.getTimeAgo(time: Long, showSeconds: Boolean = false): String {
    return resources.getTimeAgo(time, showSeconds)
}

/**
 * Provides relative time [String]
 *
 * @receiver resources.
 * @param date time of the event.
 * @param showSeconds **true** — show exact seconds count if time difference is less than minute;
 *                    **false** — shows "just now" message if time difference is less than minute.
 */
fun Resources.getTimeAgo(date: Date, showSeconds: Boolean = false): String {
    return getTimeAgo(date.time, showSeconds)
}

/**
 * Provides relative time [String]
 *
 * @receiver resources.
 * @param time time of the event (in millis).
 * @param showSeconds **true** — show exact seconds count if time difference is less than minute;
 *                    **false** — shows "just now" message if time difference is less than minute.
 */
fun Resources.getTimeAgo(time: Long, showSeconds: Boolean = false): String {
    val diff = System.currentTimeMillis() - time
    return getBlitzTime(diff).getText(this, diff, showSeconds)
}

/**
 * Sets relative time [String] to the [TextView]
 *
 * @receiver [TextView]: target for time [String] setting.
 * @param date time of the event.
 * @param showSeconds **true** — show exact seconds count if time difference is less than minute;
 *                    **false** — shows "just now" message if time difference is less than minute.
 * @param autoUpdate **true** — current [TextView] will update itself automatically;
 *                   **false** — set relative time [String] only once.
 */
fun TextView.setTimeAgo(
    date: Date,
    showSeconds: Boolean = false,
    autoUpdate: Boolean = true
) {
    setTimeAgo(date.time, showSeconds, autoUpdate)
}

/**
 * Sets relative time [String] to the [TextView]
 *
 * @receiver [TextView]: target for time [String] setting.
 * @param time time of the event (in millis).
 * @param showSeconds **true** — show exact seconds count if time difference is less than minute;
 *                    **false** — shows "just now" message if time difference is less than minute.
 * @param autoUpdate **true** — current [TextView] will update itself automatically;
 *                   **false** — set relative time [String] only once.
 */
fun TextView.setTimeAgo(
    time: Long,
    showSeconds: Boolean = false,
    autoUpdate: Boolean = true
) {
    if (!autoUpdate) {
        this.diffedValue = context.getTimeAgo(time, showSeconds)
    }

    val tag = getTag(R.id.blitz)
    val stateChangeListener: BlitzAttachListener

    if (tag is BlitzAttachListener) {
        stateChangeListener = tag
    } else {
        stateChangeListener = BlitzAttachListener(this)
        addOnAttachStateChangeListener(stateChangeListener)
        setTag(R.id.blitz, stateChangeListener)
    }

    stateChangeListener.showSeconds = showSeconds
    stateChangeListener.time = time
}

/**
 * Stop automatic updates of the time inside the [TextView]
 */
fun TextView.cancelTimeAgoUpdates() {
    val tag = getTag(R.id.blitz)

    if (tag !is BlitzAttachListener) return

    tag.dropCounter()
    removeOnAttachStateChangeListener(tag)
}

internal fun getBlitzTime(diff: Long): BlitzTime {
    val timeUnits = BlitzTime.values()
    return timeUnits.find { diff < it.differenceMs } ?: timeUnits.last()
}

internal fun BlitzTime.getText(resources: Resources, diff: Long, showSeconds: Boolean): String {
    return if (dividerMs == null) {
        resources.getString(singleStringResource!!)
    } else {
        if (this == BlitzTime.SECONDS && !showSeconds) {
            resources.getString(R.string.blitz_now)
        } else {
            val quantity = (diff / dividerMs).toInt()
            resources.getQuantityString(pluralResource!!, quantity, quantity)
        }
    }
}