package org.example.rbac.application.account.controller

import org.example.rbac.application.account.dto.request.AccountSignInRequest
import org.example.rbac.application.account.dto.request.AccountSignupRequest
import org.example.rbac.application.account.dto.request.EmailVerifyRequest
import org.example.rbac.application.account.dto.request.VerifyEmailRequest
import org.example.rbac.application.account.dto.response.AccountSignInSuccessResponse
import org.example.rbac.application.account.dto.response.AccountSignupSuccessResponse
import org.example.rbac.application.common.httpresponse.HttpApiResponse
import org.example.rbac.domain.account.service.EmailVerifyUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/account")
class AccountCommandController(
    private val emailVerifyUseCase: EmailVerifyUseCase,
) {
    @PostMapping("/signup")
    fun signUp(
        @RequestBody requestBody: AccountSignupRequest
    ): AccountSignupSuccessResponse {
        return AccountSignupSuccessResponse(
            id = 1L,
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
    ): HttpApiResponse<Unit> {
        emailVerifyUseCase.sendVerifyCodeToEmail(requestBody.email)
        return HttpApiResponse.ok()
    }

    /**
     * 이메일로 받은 인증코드 확인
     */
    @PostMapping("/verify/email/code")
    fun verifyEmailCode(
        @RequestBody requestBody: VerifyEmailRequest,
    ): HttpApiResponse<Unit> {
        emailVerifyUseCase.verifyEmailCode(requestBody.email, requestBody.code)
        return HttpApiResponse.ok()
    }

}