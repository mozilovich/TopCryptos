package com.example.topcryptos.presentation.ui.currencies

import com.example.topcryptos.domain.gateway.CurrenciesGateway
import com.example.topcryptos.domain.usecase.GetCurrenciesUseCase
import com.example.topcryptos.presentation.base.BasePresenter
import com.example.topcryptos.presentation.model.CurrencyModel
import com.example.topcryptos.presentation.model.CurrencyModelMapper
import com.example.topcryptos.presentation.rx.PresentationSingleTransformer
import javax.inject.Inject

class CurrenciesPresenter @Inject constructor() : BasePresenter<CurrenciesView>() {

    @Inject
    lateinit var getCurrenciesUseCase: GetCurrenciesUseCase

    override fun attachView() {
        super.attachView()
        update()
    }

    fun onCurrencyClick(currencyModel: CurrencyModel) {
        view.navigateCurrencyInfo(currencyModel)
    }

    fun onRetry() {
        update()
    }

    private fun update() {
        getCurrenciesUseCase
                .getCurrenciesObservable()
                .map(CurrencyModelMapper::map)
                .toList()
                .compose(PresentationSingleTransformer())
                .doOnSubscribe {
                    view.showProgress()
                    view.hideRetry()
                }
                .doAfterTerminate {
                    view.hideProgress()
                }
                .subscribe({
                    view.showCurrencies(it)
                }, {
                    view.showRetry()
                }).disposeWhenDestroy()
    }
}