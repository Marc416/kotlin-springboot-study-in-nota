package org.example.rbac.domain.account.service

import org.example.rbac.application.account.dto.response.AccountSignupSuccessResponse
import org.example.rbac.domain.account.entity.Account
import org.example.rbac.domain.account.entity.AccountRole

class AccountCommandService:AccountCommandUseCase {
    override fun signUp(
        email: String,
        password: String,
        tenantKey: String,
        role: AccountRole
    ): AccountSignupSuccessResponse {
        val account = Account.createActiveAccount(email, password, tenantKey, role)
        return AccountSignupSuccessResponse(
            id = account.id,
            createdAt = account.createdAt
        )
    }
}