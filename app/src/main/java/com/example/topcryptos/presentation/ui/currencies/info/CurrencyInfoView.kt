package com.example.topcryptos.presentation.ui.currencies.info

import com.example.topcryptos.presentation.base.BaseView
import com.example.topcryptos.presentation.model.CurrencyModel

interface CurrencyInfoView: BaseView {

    fun showProgress()

    fun hideProgress()

    fun addChartEntry(value: Float, date: Float)

    fun showRetry()

    fun hideRetry()

    fun showCurrencyInfo(model: CurrencyModel)
}