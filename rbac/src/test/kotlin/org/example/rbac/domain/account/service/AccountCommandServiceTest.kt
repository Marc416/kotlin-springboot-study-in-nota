package org.example.rbac.domain.account.service

import org.assertj.core.api.Assertions.assertThat
import org.example.rbac.application.account.repository.FakeAccountRepositoryImpl
import org.example.rbac.domain.account.entity.AccountRole
import org.example.rbac.domain.account.repository.AccountRepository
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class AccountCommandServiceTest {

    private lateinit var accountCommandUseCase: AccountCommandUseCase
    private lateinit var accountRepositoryImpl: AccountRepository

    @BeforeEach
    fun init() {
        accountRepositoryImpl = FakeAccountRepositoryImpl()
        accountCommandUseCase = AccountCommandService(
            accountRepository = accountRepositoryImpl
        )
    }

    @Test
    fun `계정생성 성공`() {
        // Arrange
        val email: String = "test@example.rbac"
        val password: String = "test"
        val tenantKey: String = "Nota"
        val role: AccountRole = AccountRole.USER

        // Action
        val createdAccount1 = accountCommandUseCase.signUp(
            email = email,
            password = password,
            tenantKey = tenantKey,
            role = role
        )

        val createdAccount2 = accountCommandUseCase.signUp(
            email = email + "2",
            password = password,
            tenantKey = tenantKey,
            role = role
        )

        // Assert
        val savedAccount1 = accountRepositoryImpl.findByAccountId(createdAccount1.id)
        assertThat(createdAccount1.id).isEqualTo(savedAccount1.id)
        assertThat(createdAccount2.id).isEqualTo(createdAccount2.id)
    }
}