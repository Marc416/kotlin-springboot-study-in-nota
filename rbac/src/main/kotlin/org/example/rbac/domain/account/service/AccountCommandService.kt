package org.example.rbac.domain.account.service

import org.example.rbac.application.account.dto.response.AccountSignInSuccessResponse
import org.example.rbac.application.account.dto.response.AccountSignupSuccessResponse
import org.example.rbac.domain.account.dto.AccountJwtPayload
import org.example.rbac.domain.account.entity.Account
import org.example.rbac.domain.account.entity.AccountRole
import org.example.rbac.domain.account.repository.AccountRepository
import org.example.rbac.domain.common.JwtTokenProvider
import org.springframework.stereotype.Service

@Service
class AccountCommandService(
    private val accountRepository: AccountRepository,
    private val jwtTokenProvider: JwtTokenProvider
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

    override fun signIn(email: String, tenantKey: String, password: String): AccountSignInSuccessResponse {
        val account = accountRepository.findByEmailAndTenantKey(
            email = email,
            tenantKey = tenantKey
        )

        // TODO: 비밀번호 검증 로직 추가(passwordEncoder 사용)

        val accountPayload = AccountJwtPayload(
            accountId = account.id,
            tenantKey = account.tenantKey,
            role = account.role.name
        ).toMap()

        val token = jwtTokenProvider.generateToken(accountPayload, 1000 * 60 * 60 * 24)
        return AccountSignInSuccessResponse(token)
    }
}