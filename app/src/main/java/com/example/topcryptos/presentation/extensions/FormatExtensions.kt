package com.example.topcryptos.presentation.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Number.formatWithDecimalsPlaces(decimals: Int): String {
    return String.format(Locale.US, "%.${decimals}f", this)
}

fun Long.formatPresentationMonthDayYearDate(): String {
    val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    return sdf.format(Date(this))
}

fun Long.formatPresentationMonthYearDate(): String {
    val sdf = SimpleDateFormat("\"MMM yyyy", Locale.getDefault())
    return sdf.format(Date(this))
}