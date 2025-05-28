package org.example.rbac.application.common

import org.assertj.core.api.Assertions.assertThat
import org.example.rbac.domain.common.JwtTokenProvider
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class JwtTokenProviderImplTest {

    private lateinit var jwtTokenProvider: JwtTokenProvider

    @BeforeEach
    fun setUp() {
        jwtTokenProvider = JwtTokenProviderImpl(
            secretKey = "SECRET_KEY",
        )
    }

    @Test
    fun `토큰 오류시`() {
        // Arrange, Action
        val res = jwtTokenProvider.validateToken("")

        // Assert
        assertThat(res).isFalse()
    }

    @Test
    fun `인증토큰에 accountId tenantKey role 이 있다`(){
        // Arrange
        // (Live로 만들어보기)
        // Action

        // Assert
    }
}