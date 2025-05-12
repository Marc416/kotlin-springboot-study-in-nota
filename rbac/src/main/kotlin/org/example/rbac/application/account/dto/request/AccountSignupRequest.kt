package org.example.rbac.application.account.dto.request

data class AccountSignupRequest(
    val email: String,
    val password: String,
    val tenantKey: String,
    val role: String,
)
