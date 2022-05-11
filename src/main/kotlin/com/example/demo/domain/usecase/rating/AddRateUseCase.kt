package com.example.demo.domain.usecase.rating

import com.example.demo.domain.adapter.RateRepository
import com.example.demo.domain.entity.Rate
import org.springframework.stereotype.Service

@Service
class AddRateUseCase(private val rateRepository: RateRepository) {

    fun add(rate: Rate) = rateRepository.addRate(rate)


}