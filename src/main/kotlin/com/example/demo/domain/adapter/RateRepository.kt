package com.example.demo.domain.adapter

import com.example.demo.domain.entity.Rate
import com.example.demo.domain.entity.RateAverage

interface RateRepository {

    fun addRate(rate: Rate)

    fun getAllRates(): MutableList<Rate>

    suspend fun getRatesByMerchantId(merchantId: String): MutableList<Rate>

    suspend fun getMerchantAverage(merchantId: String): RateAverage

}