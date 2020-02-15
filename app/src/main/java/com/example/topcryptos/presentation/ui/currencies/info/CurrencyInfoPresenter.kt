package com.example.topcryptos.presentation.ui.currencies.info

import com.example.topcryptos.domain.gateway.CurrenciesGateway
import com.example.topcryptos.presentation.base.BasePresenter
import com.example.topcryptos.presentation.base.BaseView
import com.example.topcryptos.presentation.model.CurrencyChartModelMapper
import com.example.topcryptos.presentation.model.CurrencyModel
import com.example.topcryptos.presentation.rx.PresentationObservableTransformer
import javax.inject.Inject

class CurrencyInfoPresenter @Inject constructor(): BasePresenter<CurrencyInfoView>() {

    @Inject
    lateinit var currenciesGateway: CurrenciesGateway

    lateinit var model: CurrencyModel

    fun onAttach(v: CurrencyInfoView, model: CurrencyModel) {
        this.view = v
        this.model = model
        update()
    }

    fun onRetry() {
        update()
    }

    private fun update() {
        currenciesGateway
                .getCurrencyChartObservable(model.id)
                .map(CurrencyChartModelMapper::map)
                .compose(PresentationObservableTransformer())
                .doOnSubscribe {
                    view.showProgress()
                    view.hideRetry()
                }
                .doAfterTerminate {
                    view.hideProgress()
                }
                .doOnComplete {
                    view.showCurrencyInfo(model)
                }
                .subscribe({
                    view.addChartEntry(it.value, it.date)
                }, {
                    view.showRetry()
                })
                .disposeWhenDestroy()
    }
}