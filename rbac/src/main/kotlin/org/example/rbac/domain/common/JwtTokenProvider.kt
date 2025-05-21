package org.example.rbac.domain.common

import org.example.rbac.domain.account.dto.AccountJwtPayload


interface JwtTokenProvider {
    fun parseAuthorizationToken(token: String): AccountJwtPayload

    fun validateToken(token: String): Boolean
    fun generateToken(payload: Map<String, Any>, ttl: Int): String
}