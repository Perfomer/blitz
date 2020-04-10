package com.perfomer.blitzapp.util

import java.text.SimpleDateFormat
import java.util.*

private const val FORMAT = "yyyy-MM-dd HH:mm:ss"

internal fun Date.format(): String {
    return SimpleDateFormat(FORMAT, Locale.getDefault()).format(this)
}