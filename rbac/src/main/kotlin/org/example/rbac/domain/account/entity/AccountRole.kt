package org.example.rbac.domain.account.entity

enum class AccountRole(val inheritedRoles: Set<AccountRole>, val description: String) {
    USER(emptySet(), "일반 사용자"),
    ADMIN(setOf(USER), "관리자");
}