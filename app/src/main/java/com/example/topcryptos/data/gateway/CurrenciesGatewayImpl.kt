package com.example.topcryptos.data.gateway

import com.example.topcryptos.data.CoinGeckoApi
import com.example.topcryptos.data.mapper.CurrencyMapper
import com.example.topcryptos.domain.entity.CurrencyEntity
import com.example.topcryptos.domain.gateway.CurrenciesGateway
import com.example.topcryptos.presentation.model.CurrencyModel
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrenciesGatewayImpl @Inject constructor() : CurrenciesGateway {

    @Inject
    lateinit var api: CoinGeckoApi

    override fun getCurrenciesObservable(): Observable<CurrencyEntity> {
        return api.getCoinMarket()
            .flatMap { Observable.fromIterable(it) }
            .map(CurrencyMapper::map)
    }

    override fun getCurrencyChartObservable(currencyId: String): Observable<Pair<Float, Float>> {
        return api.getCoinMarketChart(currencyId)
                .map { it.prices }
                .flatMap { Observable.fromIterable(it) }
                .map { Pair(it[1], it[0]) }
    }
}