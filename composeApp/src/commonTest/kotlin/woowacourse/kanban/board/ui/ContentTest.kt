package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.component.KanbanCard
import woowacourse.kanban.board.component.card.domain.Kanban
import woowacourse.kanban.board.component.card.domain.Title
import woowacourse.kanban.board.component.card.domain.Title.Companion.DEFAULT_TITLE
import woowacourse.kanban.board.component.card.preview.CONTENT_EX
import woowacourse.kanban.board.component.card.preview.CONTENT_MAX_EX
import woowacourse.kanban.board.component.card.preview.NAME_EX
import woowacourse.kanban.board.component.card.preview.TAG_GROUP_EX
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class ContentTest {

    @Test
    fun `설명 정보가 없으면 설명 필드가 노출되지 않는다`() = runComposeUiTest {
        //give
        val kanban = Kanban(
            title = DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = TAG_GROUP_EX,
            profileName = NAME_EX,
        )

        setContent {
            KanbanCard(
                kanban = kanban
            )
        }

        //when
        val title = onNodeWithText(Title.DEFAULT_TITLE)
        val content = onNodeWithText(CONTENT_EX)

        //than
        title.assertExists()
        content.assertDoesNotExist()
    }

    @Test
    fun `설명이 매우 길어도 설명 필드는 렌더링된다`() = runComposeUiTest {
        //give
        val kanban = Kanban(
            title = "   ",
            content = CONTENT_EX,
            tags = TAG_GROUP_EX,
            profileName = NAME_EX,
        )

        setContent {
            KanbanCard(
                kanban = kanban
            )
        }

        //when
        val content = onNodeWithText(CONTENT_MAX_EX)

        //than
        content.assertExists()
    }
}
