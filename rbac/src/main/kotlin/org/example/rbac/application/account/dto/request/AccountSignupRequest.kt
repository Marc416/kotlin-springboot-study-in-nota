package org.example.rbac.application.account.dto.request

import org.example.rbac.domain.account.entity.AccountRole

data class AccountSignupRequest(
    val email: String,
    val password: String,
    val tenantKey: String,
    val role: AccountRole,
)
