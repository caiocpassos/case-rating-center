package com.example.demo.domain.adapter

import com.example.demo.domain.entity.Rate
import com.example.demo.domain.entity.Average

interface RateRepository {

    suspend fun addRate(rate: Rate)

    suspend fun getRatesByMerchantId(merchantId: String): MutableList<Rate>

    suspend fun getMerchantAverage(merchantId: String): Average

}