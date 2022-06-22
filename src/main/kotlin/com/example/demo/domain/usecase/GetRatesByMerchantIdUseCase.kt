package com.example.demo.domain.usecase

import com.example.demo.domain.adapter.RateRepository
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class GetRatesByMerchantIdUseCase(private val rateRepository: RateRepository) {

    fun getBy(merchantId: String) = runBlocking {
        rateRepository.getRatesByMerchantId(merchantId)
    }

}