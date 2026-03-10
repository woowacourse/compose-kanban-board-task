package woowacourse.kanban.board.model

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import kotlin.test.Test

class TagTest {
    @Test
    fun `태그 길이가 5자일 때 오류가 발생하지 않는다`() {
        // given
        val content = "태그5글자"
        // when & then
        assertThatCode {
            Tag(content)
        }.doesNotThrowAnyException()
    }

    @Test
    fun `태그 길이가 6자일 때 오류가 발생한다`() {
        // given
        val content = "태그여섯글자"
        // when & then
        assertThatThrownBy {
            Tag(content)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("태그 길이는 5글자까지 입력 가능합니다.")
    }
}
