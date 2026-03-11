package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.component.KanbanCard
import woowacourse.kanban.board.component.card.domain.Kanban
import woowacourse.kanban.board.component.card.domain.Title
import woowacourse.kanban.board.component.card.preview.CONTENT_EX
import woowacourse.kanban.board.component.card.preview.NAME_EX
import woowacourse.kanban.board.component.card.preview.TAG_GROUP_EX
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class KanbanCardUiTest {

    @Test
    fun `모든 정보가 있으면 모든 필드가 노출된다`() = runComposeUiTest {
        //give
        val kanban = Kanban(
            title = Title.DEFAULT_TITLE,
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
        val firstTag = onNodeWithText(TAG_GROUP_EX[0])
        val lastTag = onNodeWithText(TAG_GROUP_EX[1])
        val profile = onNodeWithText(NAME_EX)

        //than
        title.assertExists()
        content.assertExists()
        firstTag.assertExists()
        lastTag.assertExists()
        profile.assertExists()
    }
}
