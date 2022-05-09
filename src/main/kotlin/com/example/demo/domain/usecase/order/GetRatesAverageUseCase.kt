package com.example.demo.domain.usecase.order

import com.example.demo.domain.adapter.MerchantRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetRatesAverageUseCase(private val merchantRepository: MerchantRepository) {

    fun get(merchantUUID: UUID) = merchantRepository.getAverage(merchantUUID)

}