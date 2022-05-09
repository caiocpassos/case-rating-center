package com.example.demo.domain.usecase.merchant

import com.example.demo.domain.adapter.MerchantRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetAllRatesUseCase(private val merchantRepository: MerchantRepository) {

    fun getAll(merchantUUID: UUID) =
        merchantRepository.getAllRates(merchantUUID)

}