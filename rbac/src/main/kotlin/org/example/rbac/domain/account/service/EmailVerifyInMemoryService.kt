package org.example.rbac.domain.account.service

import java.util.*

class EmailVerifyInMemoryService :EmailVerifyUseCase{
    override fun sendVerifyCodeToEmail(email: String): String {
        val code = generateVerificationCode()
        // TODO 생성한 코드를 어딘가에 저장해야 함
        // TODO 생성한 코드를 고객 이메일로 전송
        return code
    }

    override fun verifyEmailCode(email: String, code: String): Boolean {
        TODO("Not yet implemented")
    }

    private fun generateVerificationCode(): String {
        return java.lang.String.valueOf(Random().nextInt(900000) + 100000) // 6자리 숫자 코드 생성
    }
}