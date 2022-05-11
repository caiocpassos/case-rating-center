package com.example.demo.database

import com.example.demo.domain.adapter.RateRepository
import com.example.demo.domain.entity.Rate
import com.example.demo.http.dto.RateMerchantDto
import org.springframework.stereotype.Repository

@Repository
object RateDatabaseSimulator : RateRepository{
    private val rateDatabase: MutableList<Rate> = mutableListOf()


    override fun addRate(rate: Rate) {
        rateDatabase.add(rate)
    }

    override fun getAllRates(): MutableList<Rate> {
        return rateDatabase
    }

    override fun getMerchantAverage(merchantId: String): RateMerchantDto {
        var soma = 0.0
        val filteredRateDatabase = rateDatabase
            .filter { it.merchantId == merchantId && it.rateValue != null }

            filteredRateDatabase.forEach { soma += it.rateValue!! }

        return RateMerchantDto(
            merchantId = merchantId,
            rateValue = soma / filteredRateDatabase.size
        )
    }

}