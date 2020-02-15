package com.example.topcryptos.presentation.util

import com.example.topcryptos.presentation.extensions.formatPresentationMonthYearDate
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import java.util.*

class ChatDateFormatter: IAxisValueFormatter {

    override fun getFormattedValue(value: Float, axis: AxisBase?): String {
        return value.toLong().formatPresentationMonthYearDate()
    }
}