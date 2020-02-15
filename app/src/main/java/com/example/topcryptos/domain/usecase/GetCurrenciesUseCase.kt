package com.example.topcryptos.domain.usecase

import com.example.topcryptos.domain.entity.CurrencyEntity
import com.example.topcryptos.domain.gateway.CurrenciesGateway
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCurrenciesUseCase @Inject constructor(private var currenciesGateway: CurrenciesGateway){

    fun getCurrenciesObservable(): Observable<CurrencyEntity> {
        return currenciesGateway.getCurrenciesObservable()
    }
}