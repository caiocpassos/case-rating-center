package com.example.demo.domain.usecase.merchant

import com.example.demo.domain.adapter.MerchantRepository
import org.springframework.stereotype.Service

@Service
class GetAllMerchantsUseCase(private val merchantRepository: MerchantRepository) {

    fun getAll() = merchantRepository.getAllMerchants()

}