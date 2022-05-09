package com.example.demo.domain.usecase.merchant

import com.example.demo.domain.adapter.MerchantRepository
import com.example.demo.http.dto.MerchantForm
import org.springframework.stereotype.Service

@Service
class CreateMerchantUseCase(private val merchantRepository: MerchantRepository) {

    fun create(merchant: MerchantForm) =
        merchantRepository.createMerchant(merchant)

}