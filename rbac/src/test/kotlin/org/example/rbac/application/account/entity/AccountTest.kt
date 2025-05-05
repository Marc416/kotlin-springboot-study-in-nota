package org.example.rbac.application.account.entity

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class AccountTest {
    @Test
    fun `계정 생성하기`() {
        // Arrange
        val email: String = "test@example.rbac.org"
        val password: String = "test"
        val tenantKey: String = "Nota"
        val accountRole = AccountRole.USER

        // Action
        val newAccount = Account.createActiveAccount(
            email = email,
            password = password,
            tenantKey = tenantKey,
            role = accountRole
        )

        // Assert
        assertThat(newAccount.email).isEqualTo(email)
        assertThat(newAccount.password).isEqualTo(password)
    }
}