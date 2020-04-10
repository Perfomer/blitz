package com.perfomer.blitz

import android.content.Context
import android.widget.TextView
import java.util.*

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
    if (autoUpdate) {
        val tag = getTag(R.id.blitz)
        val stateChangeListener: BlitzAttachListener

        if (tag == null || tag !is BlitzAttachListener) {
            stateChangeListener = BlitzAttachListener(this)
            addOnAttachStateChangeListener(stateChangeListener)
            setTag(R.id.blitz, stateChangeListener)
        } else {
            stateChangeListener = tag
        }

        stateChangeListener.showSeconds = showSeconds
        stateChangeListener.time = time
    } else {
        this.diffedValue = context.getTimeAgo(time, showSeconds)
    }
}

fun TextView.cancelTimeAgoUpdates() {
    val tag = getTag(R.id.blitz)

    if (tag == null || tag !is BlitzAttachListener) {
        return
    }

    tag.dropCounter()
    removeOnAttachStateChangeListener(tag)
}

internal fun getBlitzTime(diff: Long): BlitzTime {
    return BlitzTime.values().find { diff < it.differenceMs } ?: BlitzTime.YEARS
}

internal fun BlitzTime.getText(context: Context, diff: Long, showSeconds: Boolean): String {
    return if (dividerMs == null) {
        context.getString(textResource)
    } else {
        if (this == BlitzTime.SECONDS && !showSeconds) {
            context.getString(R.string.blitz_now)
        } else {
            context.getString(textResource, diff / dividerMs)
        }
    }
}