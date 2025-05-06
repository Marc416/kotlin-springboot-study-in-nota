package org.example.rbac.domain.account.service

import java.util.*
import java.util.concurrent.ConcurrentHashMap

class EmailVerifyInMemoryService : EmailVerifyUseCase {
    private val verificationCodes: MutableMap<String, String> = ConcurrentHashMap()

    override fun sendVerifyCodeToEmail(email: String): String {
        val code = generateVerificationCode()
        verificationCodes[email] = code
        // TODO 생성한 코드를 고객 이메일로 전송
        return code
    }

    override fun verifyEmailCode(email: String, code: String): Boolean {
        return verificationCodes.containsKey(email) && verificationCodes[email] == code
    }

    private fun generateVerificationCode(): String {
        return java.lang.String.valueOf(Random().nextInt(900000) + 100000) // 6자리 숫자 코드 생성
    }
}