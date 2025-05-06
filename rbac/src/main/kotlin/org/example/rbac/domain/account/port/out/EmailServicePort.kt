package org.example.rbac.domain.account.port.out

interface EmailServicePort {
    fun send(email: String, code: String): Boolean
}