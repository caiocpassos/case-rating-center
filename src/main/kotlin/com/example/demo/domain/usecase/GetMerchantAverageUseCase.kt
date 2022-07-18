package com.example.demo.domain.usecase

import com.example.demo.domain.adapter.RateRepository
import com.example.demo.domain.entity.Average
import org.springframework.stereotype.Service

@Service
class GetMerchantAverageUseCase(private val rateRepository: RateRepository) {

    suspend fun getAverage(merchantId: String): Average {
        return rateRepository.getMerchantAverage(merchantId)
    }
}