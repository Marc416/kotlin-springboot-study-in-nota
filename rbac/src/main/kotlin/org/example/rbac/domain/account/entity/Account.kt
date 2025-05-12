package org.example.rbac.domain.account.entity

import java.time.LocalDateTime

class Account(
    val email: String,
    password: String,
    val tenantKey: String,
    status: AccountStatus,
    val role: AccountRole,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {

    val id: Long = 0L
    var password: String = password
        private set

    var status: AccountStatus = status
        private set
    var deletedAt: LocalDateTime? = null
        private set

    companion object {
        fun createActiveAccount(
            email: String,
            password: String,
            tenantKey: String,
            role: AccountRole,
        ): Account {
            return Account(
                email = email,
                password = password,
                tenantKey = tenantKey,
                status = AccountStatus.ACTIVE,
                role = role,
            )
        }
    }

}