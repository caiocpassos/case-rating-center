package com.example.demo.domain.usecase

import com.example.demo.domain.adapter.RateRepository
import com.example.demo.domain.entity.Rate
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)
internal class GetRatesByMerchantIdUseCaseTestc {

    @MockK
    private lateinit var rateRepositoryMockk: RateRepository

    @InjectMockKs
    private lateinit var sut: GetRatesByMerchantIdUseCase

    @Test
    fun `Should call rateRepository GetRatesByMerchantId method with the correct parameters`() {

        val merchantId = UUID.randomUUID().toString()

        val rate = Rate(
            orderId = UUID.randomUUID().toString(),
            merchantId = merchantId,
            clientId = UUID.randomUUID().toString(),
            value = 3
        )

        coEvery {
            rateRepositoryMockk.getRatesByMerchantId(merchantId)
        } returns mutableListOf(rate)

        sut.getBy(merchantId)

        coVerify {
            rateRepositoryMockk.getRatesByMerchantId(merchantId)
        }
    }

}