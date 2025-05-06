package org.example.rbac.domain.account.service

import org.example.rbac.application.account.dto.response.AccountSignupSuccessResponse
import org.example.rbac.domain.account.entity.Account
import org.example.rbac.domain.account.entity.AccountRole
import org.example.rbac.domain.account.repository.AccountRepository

class AccountCommandService(
    private val accountRepository: AccountRepository,
):AccountCommandUseCase {
    override fun signUp(
        email: String,
        password: String,
        tenantKey: String,
        role: AccountRole
    ): AccountSignupSuccessResponse {
        val account = Account.createActiveAccount(email, password, tenantKey, role)
        val createdAccount = accountRepository.save(account)
        return AccountSignupSuccessResponse(
            id = createdAccount.id,
            createdAt = createdAccount.createdAt
        )
    }
}