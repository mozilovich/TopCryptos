package com.example.topcryptos.domain.entity

data class CurrencyEntity(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Float,
    val marketCap: Float,
    val marketCapRank: Int,
    val totalVolume: Float,
    val priceChangePercentage24h: Float,
    val marketCapChangePercentage24h: Float,
    val circulatingSupply: Double,
    val totalSupply: Long,
    val ath: Float,
    val athChangePercentage: Float
)