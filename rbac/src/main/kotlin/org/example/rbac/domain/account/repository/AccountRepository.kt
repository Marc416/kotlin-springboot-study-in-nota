package org.example.rbac.domain.account.repository

import org.example.rbac.domain.account.entity.Account

interface AccountRepository {
    fun save(account: Account): Account
    fun findByAccountId(accountId: Long): Account
}