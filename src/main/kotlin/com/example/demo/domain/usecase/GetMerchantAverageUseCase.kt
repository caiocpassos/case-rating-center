package com.example.demo.domain.usecase

import com.example.demo.domain.adapter.RateRepository
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class GetMerchantAverageUseCase(private val rateRepository: RateRepository) {

    fun getAverage(merchantId: String) = runBlocking {
        rateRepository.getMerchantAverage(merchantId)
    }
}