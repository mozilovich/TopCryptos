package com.example.topcryptos.domain.gateway

import com.example.topcryptos.domain.entity.CurrencyEntity
import io.reactivex.Observable

interface CurrenciesGateway {

    fun getCurrenciesObservable(): Observable<CurrencyEntity>

    fun getCurrencyChartObservable(currencyId: String): Observable<Pair<Float, Float>>
}