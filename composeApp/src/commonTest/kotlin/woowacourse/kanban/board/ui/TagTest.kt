package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.component.KanbanCard
import woowacourse.kanban.board.component.card.domain.Kanban
import woowacourse.kanban.board.component.card.domain.Title
import woowacourse.kanban.board.component.card.preview.CONTENT_EX
import woowacourse.kanban.board.component.card.preview.NAME_EX
import woowacourse.kanban.board.component.card.preview.TAG_EX
import woowacourse.kanban.board.component.card.preview.TAG_GROUP_MAX_EX
import woowacourse.kanban.board.component.card.preview.TAG_MAX_EX
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TagTest {

    @Test
    fun `태그가 5글자를 넘으면 5글자만 표현된다`() = runComposeUiTest {
        //give
        val kanban = Kanban(
            title = Title.DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = listOf(TAG_EX, TAG_MAX_EX),
            profileName = NAME_EX,
        )
        setContent {
            KanbanCard(
                kanban = kanban
            )
        }

        //when
        val normalTag = onNodeWithText(TAG_EX)
        val overLengthTag = onNodeWithText(TAG_MAX_EX)

        //than
        normalTag.assertExists()
        overLengthTag.assertDoesNotExist()
    }

    @Test
    fun `태그가 6개 이상이면 5개만 표현된다`() = runComposeUiTest {
        //give
        val kanban = Kanban(
            title = Title.DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = TAG_GROUP_MAX_EX,
            profileName = NAME_EX,
        )

        setContent {
            KanbanCard(
                kanban = kanban
            )
        }

        //when
        val tagFirst = onNodeWithText(TAG_GROUP_MAX_EX[0])
        val tagSecond = onNodeWithText(TAG_GROUP_MAX_EX[1])
        val tagThird = onNodeWithText(TAG_GROUP_MAX_EX[2])
        val tagFourth = onNodeWithText(TAG_GROUP_MAX_EX[3])
        val tagFifth = onNodeWithText(TAG_GROUP_MAX_EX[4])
        val tagSixth = onNodeWithText(TAG_GROUP_MAX_EX[5])

        //than
        tagFirst.assertExists()
        tagSecond.assertExists()
        tagThird.assertExists()
        tagFourth.assertExists()
        tagFifth.assertExists()
        tagSixth.assertDoesNotExist()
    }

    @Test
    fun `태그가 공백만 포함되면 노출되지 않는다`() = runComposeUiTest {
        //give
        val kanban = Kanban(
            title = Title.DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = listOf("   ", TAG_EX),
            profileName = NAME_EX,
        )

        setContent {
            KanbanCard(
                kanban = kanban
            )
        }

        //when
        val blankTag = onNodeWithText("   ")
        val normalTag = onNodeWithText(TAG_EX)

        //than
        blankTag.assertDoesNotExist()
        normalTag.assertExists()
    }
}
