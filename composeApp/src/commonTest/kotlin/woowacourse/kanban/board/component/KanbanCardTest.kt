package woowacourse.kanban.board.component

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.assertFailsWith
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class KanbanCardTest {
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

    @Test
    fun `모든 필드가 있는 카드 테스트`() = runComposeUiTest {
        // given
        val kanbanCardForm = KanbanCardForm(title = "LazyColumn 컴포넌트 구현", crewName = "다이노")
        val content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."
        val tags = listOf("컴포넌트", "성능")

        // when
        setContent {
            KanbanCard(
                kanbanCardForm = kanbanCardForm,
                tags = tags,
                content = content,
            )
        }

        // then
        onNodeWithText("LazyColumn 컴포넌트 구현").assertExists()
        onNodeWithText("다이노").assertExists()
        onNodeWithText("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.").assertExists()
        onNodeWithText("컴포넌트").assertExists()
        onNodeWithText("성능").assertExists()
    }

    @Test
    fun `6개 이상 태그가 입력되면 5개 제한 테스트`() = runComposeUiTest {
        // given
        val kanbanCardForm = KanbanCardForm(title = "LazyColumn 컴포넌트 구현", crewName = "다이노")
        val tags = listOf("6개", "이상의", "태그가", "들어오면", "5개까지", "렌더링")

        // when
        setContent {
            KanbanCard(
                kanbanCardForm = kanbanCardForm,
                tags = tags,
            )
        }

        // then
        onAllNodesWithTag("태그 칩").assertCountEquals(5)
        onNodeWithText("렌더링").assertDoesNotExist()
    }
}
