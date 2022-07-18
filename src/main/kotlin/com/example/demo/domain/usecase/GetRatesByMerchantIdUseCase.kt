package com.example.demo.domain.usecase

import com.example.demo.domain.adapter.RateRepository
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class GetRatesByMerchantIdUseCase(private val rateRepository: RateRepository) {

    suspend fun getBy(merchantId: String) {
        rateRepository.getRatesByMerchantId(merchantId)
    }

}