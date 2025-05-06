package org.example.rbac.application.account.repository

import org.example.rbac.domain.account.entity.Account
import org.example.rbac.domain.account.repository.AccountRepository
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaField

class FakeAccountRepositoryImpl : AccountRepository {
    private val map = mutableMapOf<Long, Account>()
    override fun save(account: Account): Account {
        val id = generateId()

        // Kotlin 리플렉션으로 id 필드 설정 (JDBC 구현체들이 동일하게 리플렉션으로 ID를 바꾸므로 테스트코드도 동일하게 변경)
        val kClass = account::class
        val idProperty = kClass.memberProperties.firstOrNull { it.name == "id" }

        idProperty?.let {
            it.javaField?.isAccessible = true
            it.javaField?.set(account, id)
        }

        map[id] = account
        return account
    }

    override fun findByAccountId(accountId: Long): Account {
        // TODO 아직 Application Exception 을 만들지 않았으므로 제너럴한 예외를 던지기
        return map[accountId]?.let { return it } ?: throw Exception("Account not found")
    }

    private fun generateId(): Long {
        return map.keys.lastOrNull()?.plus(1) ?: 1L
    }
}