package com.example.demo.domain.usecase.rating

import com.example.demo.domain.adapter.RateRepository
import org.springframework.stereotype.Service

@Service
class GetMerchantAverageUseCase(private val rateRepository: RateRepository) {

    fun getAverage(merchantId: String) = rateRepository.getMerchantAverage(merchantId)

}