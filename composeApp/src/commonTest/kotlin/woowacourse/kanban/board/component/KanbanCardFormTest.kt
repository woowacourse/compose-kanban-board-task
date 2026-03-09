package woowacourse.kanban.board.component

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.assertFailsWith
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class KanbanCardFormTest {
    @Test
    fun `제목에 비어있거나 공백이 입력되면 에러가 발생`() = runComposeUiTest {
        // when & then
        assertFailsWith<IllegalArgumentException> {
            KanbanCardForm("", "바드")
            KanbanCardForm("      ", "바드")
        }
    }

    @Test
    fun `담당자가 비어있거나 공백이 입력되면 에러가 발생`() = runComposeUiTest {
        // when & then
        assertFailsWith<IllegalArgumentException> {
            KanbanCardForm("제목 이름", "")
            KanbanCardForm("제목 이름", "         ")
        }
    }
}
