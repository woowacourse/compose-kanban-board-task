package woowacourse.kanban.board.model

import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class AssigneeTest {
    @Test
    fun `담당자는 빈 텍스트일 수 없다`() {
        assertThatThrownBy {
            Assignee("")
        }
    }

    @Test
    fun `담당자는 빈 텍스트가 아니라면 생성할 수 있다`() {
        assertThat(Assignee("홍길동").name)
            .isEqualTo("홍길동")
    }
}
