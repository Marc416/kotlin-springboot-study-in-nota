package org.example.rbac.domain.account.service

import org.example.rbac.application.account.dto.response.AccountSignupSuccessResponse
import org.example.rbac.domain.account.entity.AccountRole

interface AccountCommandUseCase {
    fun signUp(
        email: String,
        password: String,
        tenantKey: String,
        role: AccountRole,
    ): AccountSignupSuccessResponse

}