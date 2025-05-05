package org.example.rbac.application.account.entity

import java.time.LocalDateTime

class Account(
    val email: String,
    password: String,
    val tenantKey: String,
    status: String,
    val role: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {

    val id: Long = 0L
    var password: String = password
        private set

    var status: String = status
        private set
    var deletedAt: LocalDateTime? = null
        private set

}