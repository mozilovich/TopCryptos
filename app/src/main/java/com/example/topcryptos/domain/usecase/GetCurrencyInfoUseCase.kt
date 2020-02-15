package com.example.topcryptos.domain.usecase

import com.example.topcryptos.domain.gateway.CurrenciesGateway
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCurrencyInfoUseCase @Inject constructor(private var currenciesGateway: CurrenciesGateway){

}