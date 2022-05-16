package com.example.demo.domain.usecase.rating

import com.example.demo.domain.adapter.RateRepository
import org.springframework.stereotype.Service

@Service
class GetRatesByMerchantIdUseCase(private val rateRepository: RateRepository) {

    fun getBy(merchantId: String) = rateRepository.getRatesByMerchantId(merchantId)

}