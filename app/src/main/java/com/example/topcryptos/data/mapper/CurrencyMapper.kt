package com.example.topcryptos.data.mapper

import com.example.topcryptos.data.network.pojo.response.CurrencyItem
import com.example.topcryptos.domain.entity.CurrencyEntity

object CurrencyMapper {

    fun map(item: CurrencyItem): CurrencyEntity {
        return CurrencyEntity(
            item.id,
            item.symbol,
            item.name,
            item.image,
            item.currentPrice,
            item.marketCap,
            item.marketCapRank,
            item.totalVolume,
            item.priceChangePercentage24h,
            item.marketCapChangePercentage24h,
            item.circulatingSupply,
            item.totalSupply,
            item.ath,
            item.athChangePercentage
        )
    }
}