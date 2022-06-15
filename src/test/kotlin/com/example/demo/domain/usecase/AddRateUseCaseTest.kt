package com.example.demo.domain.usecase

import com.example.demo.domain.adapter.RateRepository
import com.example.demo.domain.entity.Rate
import com.example.demo.domain.usecase.AddRateUseCase
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.justRun
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)
internal class AddRateUseCaseTest {

    @MockK
    private lateinit var rateRepositoryMockk: RateRepository

    @InjectMockKs
    private lateinit var sut: AddRateUseCase

    @Test
    fun `Should call rateRepository with the correct parameters`() {

        val rate = Rate(
            orderId = UUID.randomUUID().toString(),
            merchantId = UUID.randomUUID().toString(),
            clientId = UUID.randomUUID().toString(),
            rateValue = 4
        )

        justRun { rateRepositoryMockk.addRate(rate) }

        //every { rateRepositoryMockk.addRate(rate) } returns

        sut.add(rate)

        verify {
            rateRepositoryMockk.addRate(rate)
        }
    }

}