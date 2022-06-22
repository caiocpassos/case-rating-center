package com.example.demo.domain.usecase

import com.example.demo.domain.adapter.RateRepository
import org.springframework.stereotype.Service

@Service
class GetAllRatesUseCase(private val rateRepository: RateRepository) {

    fun getAll() = rateRepository.getAllRates()

}