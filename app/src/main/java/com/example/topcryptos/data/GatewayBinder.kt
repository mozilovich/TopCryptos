package com.example.topcryptos.data

import com.example.topcryptos.data.gateway.CurrenciesGatewayImpl
import com.example.topcryptos.domain.gateway.CurrenciesGateway
import dagger.Binds
import dagger.Module

@Module
abstract class GatewayBinder {

    @Binds
    abstract fun bindCurrenciesGateway(gateway: CurrenciesGatewayImpl): CurrenciesGateway
}