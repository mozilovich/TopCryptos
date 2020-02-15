package com.example.topcryptos.presentation.ui.currencies

import com.example.topcryptos.presentation.base.BaseView
import com.example.topcryptos.presentation.model.CurrencyModel

interface CurrenciesView: BaseView {

    fun showCurrencies(items: List<CurrencyModel>)

    fun showProgress()

    fun hideProgress()

    fun navigateCurrencyInfo(model: CurrencyModel)

    fun showRetry()

    fun hideRetry()
}