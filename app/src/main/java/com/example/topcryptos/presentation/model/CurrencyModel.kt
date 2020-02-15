package com.example.topcryptos.presentation.model

import com.example.topcryptos.domain.entity.CurrencyEntity
import java.io.Serializable

data class CurrencyModel(
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
) : Serializable

object CurrencyModelMapper {
    fun map(entity: CurrencyEntity): CurrencyModel {
        return CurrencyModel(
                entity.id,
                entity.symbol,
                entity.name,
                entity.image,
                entity.currentPrice,
                entity.marketCap,
                entity.marketCapRank,
                entity.totalVolume,
                entity.priceChangePercentage24h,
                entity.marketCapChangePercentage24h,
                entity.circulatingSupply,
                entity.totalSupply,
                entity.ath,
                entity.athChangePercentage
        )
    }
}