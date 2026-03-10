package woowacourse.kanban.board.model

import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class TagTest {
    @Test
    fun `태그 텍스트는 빈 문자열일 수 없다`() {
        assertThatThrownBy {
            Tag("")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `태그 텍스트가 5글자를 넘어가면 예외가 발생한다`() {
        assertThatThrownBy {
            Tag("5글자를 넘어가면 안됩니다!")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `태그 텍스트가 한 글자 이상이면서 5글자 미만이면 생성할 수 있다`() {
        assertThat(Tag("한").text).isEqualTo("한")
        assertThat(Tag("5글자이하").text).isEqualTo("5글자이하")
    }
}
