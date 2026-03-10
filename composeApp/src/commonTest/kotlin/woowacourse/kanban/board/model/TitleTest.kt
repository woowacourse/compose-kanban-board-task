package woowacourse.kanban.board.model

import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class TitleTest {
    @Test
    fun `제목은 빈 텍스트일 수 없다`() {
        assertThatThrownBy {
            Title("")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `제목이 빈 텍스트가 아니라면 생성할 수 있다`() {
        assertThat(Title("근사한 제목").text)
            .isEqualTo("근사한 제목")
    }
}
