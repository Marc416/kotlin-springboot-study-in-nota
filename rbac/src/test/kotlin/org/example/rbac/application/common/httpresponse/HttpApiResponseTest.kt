package org.example.rbac.application.common.httpresponse

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class HttpApiResponseTest {
    @Test
    fun `Generic이 런타임에서 삭제되어 타입을 구분하지 않음을 확인하기`() {
        // Arrange, Action
        val responseString: HttpApiResponse<String> = HttpApiResponse.of(data = "test")
        val responseInt: HttpApiResponse<Int> = HttpApiResponse.of(data = 13)
        val intList = listOf(1, 2, 3)
        val stringList = listOf("a", "b", "c")

        // Assert
        assertThat(responseString::class).isEqualTo(responseInt::class)
        assertThat(intList::class).isEqualTo(stringList::class)
    }
}