package com.example.topcryptos.data.network.pojo.response

import com.google.gson.annotations.SerializedName

class CurrenciesChartItem {
    @field:SerializedName("prices")
    val prices: List<List<Float>> = emptyList()
}