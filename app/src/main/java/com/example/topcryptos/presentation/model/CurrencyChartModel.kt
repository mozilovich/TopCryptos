package com.example.topcryptos.presentation.model

data class CurrencyChartModel(
        val value: Float,
        val date: Float
)

object CurrencyChartModelMapper {

    fun map(pair: Pair<Float, Float>): CurrencyChartModel {
        return CurrencyChartModel(pair.first, pair.second)
    }
}