package com.example.demo.domain.adapter

import com.example.demo.domain.entity.Rate
import com.example.demo.http.dto.RateMerchantDto

interface RateRepository {

    fun addRate(rate: Rate)

    fun getAllRates(): MutableList<Rate>

    fun getRatesByMerchantId(merchantId: String): MutableList<Rate>

    fun getMerchantAverage(merchantId: String): RateMerchantDto

}