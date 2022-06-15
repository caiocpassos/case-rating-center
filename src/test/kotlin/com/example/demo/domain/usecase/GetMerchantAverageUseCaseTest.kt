package com.example.demo.domain.usecase

import com.example.demo.domain.adapter.RateRepository
import com.example.demo.domain.entity.RateAverage
import com.example.demo.domain.usecase.GetMerchantAverageUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)
internal class GetMerchantAverageUseCaseTest {

    @MockK
    private lateinit var rateRepositoryMockK: RateRepository

    @InjectMockKs
    private lateinit var sut: GetMerchantAverageUseCase

    @Test
    fun `Should call rateRepository getMerchantAverage method with the correct parameters`() {
        val merchantId = UUID.randomUUID().toString()
        val rateValue = 2.3

        coEvery {
            rateRepositoryMockK.getMerchantAverage(merchantId)
        } returns RateAverage(
            merchantId = merchantId,
            rateValue = rateValue
        )

        sut.getAverage(merchantId)

        coVerify {
            rateRepositoryMockK.getMerchantAverage(merchantId)
        }
    }
}