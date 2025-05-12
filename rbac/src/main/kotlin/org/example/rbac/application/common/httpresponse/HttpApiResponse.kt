package org.example.rbac.application.common.httpresponse

data class HttpApiResponse<T>(
    val code: CodeEnum = CodeEnum.RS_000,
    val message: String? = null,
    val data: T? = null

) {

    companion object {
        fun <T> ok(): HttpApiResponse<T> {
            return HttpApiResponse(
                code = CodeEnum.RS_000,
                message = CodeEnum.RS_000.description
            )
        }

        fun <T> of(data: T): HttpApiResponse<T> {
            return HttpApiResponse(
                code = CodeEnum.RS_000,
                message = CodeEnum.RS_000.description,
                data = data
            )
        }
    }
}