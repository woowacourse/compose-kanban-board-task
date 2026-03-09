package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.component.KanbanCard
import woowacourse.kanban.board.component.card.domain.Title
import woowacourse.kanban.board.component.card.preview.CONTENT_EX
import woowacourse.kanban.board.component.card.preview.NAME_EX
import woowacourse.kanban.board.component.card.preview.TAG_GROUP_EX
import woowacourse.kanban.board.component.card.preview.TITLE_MAX_EX
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TitleTest {

    @Test
    fun `제목 정보가 없으면 기본 제목이 노출된다`() = runComposeUiTest {
        //give
        setContent {
            KanbanCard(
                title = null,
                content = CONTENT_EX,
                tags = TAG_GROUP_EX,
                name = NAME_EX,
            )
        }

        //when
        val title = onNodeWithText(Title.DEFAULT_TITLE)
        val content = onNodeWithText(CONTENT_EX)

        //than
        title.assertExists()
        content.assertExists()
    }

    @Test
    fun `제목 정보가 공백이면 기본 제목이 노출된다`() = runComposeUiTest {
        //give
        setContent {
            KanbanCard(
                title = "  ",
                content = CONTENT_EX,
                tags = TAG_GROUP_EX,
                name = NAME_EX,
            )
        }

        //when
        val title = onNodeWithText(Title.DEFAULT_TITLE)

        //than
        title.assertExists()
    }

    @Test
    fun `제목이 매우 길어도 제목 필드는 렌더링된다`() = runComposeUiTest {
        //give
        setContent {
            KanbanCard(
                title = TITLE_MAX_EX,
                content = CONTENT_EX,
                tags = TAG_GROUP_EX,
                name = NAME_EX,
            )
        }

        //when
        val title = onNodeWithText(TITLE_MAX_EX)

        //than
        title.assertExists()
    }
}
