package org.example.rbac.application.account.controller

import com.notaaiassignmentrdbac.application.account.dto.request.AccountSignInRequest
import com.notaaiassignmentrdbac.application.account.dto.request.AccountSignupRequest
import com.notaaiassignmentrdbac.application.account.dto.request.EmailVerifyRequest
import com.notaaiassignmentrdbac.application.account.dto.request.VerifyEmailRequest
import com.notaaiassignmentrdbac.application.account.dto.response.AccountSignInSuccessResponse
import com.notaaiassignmentrdbac.application.account.dto.response.AccountSignupSuccessResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/account")
class AccountCommandController {
    @PostMapping("/signup")
    fun signUp(
        @RequestBody requestBody: AccountSignupRequest
    ): AccountSignupSuccessResponse {
        return AccountSignupSuccessResponse(
            id=1L,
            createdAt = LocalDateTime.now()
        )
    }

    @PostMapping("/signin")
    fun signIn(
        @RequestBody requestBody: AccountSignInRequest
    ): AccountSignInSuccessResponse {
        return AccountSignInSuccessResponse(
            token = "JWT token"
        )
    }

    /**
     * 인증코드 이메일 전송
     */
    @PostMapping("/verify/email")
    fun sendVerifyCodeToEmail(
        @RequestBody requestBody: EmailVerifyRequest
    ) {
        return
    }

    /**
     * 이메일로 받은 인증코드 확인
     */
    @PostMapping("/verify/email/code")
    fun verifyEmailCode(
        @RequestBody requestBody: VerifyEmailRequest,
    ) {
        return
    }

}