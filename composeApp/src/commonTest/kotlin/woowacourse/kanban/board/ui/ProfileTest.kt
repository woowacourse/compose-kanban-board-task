package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.component.KanbanCard
import woowacourse.kanban.board.component.card.domain.Kanban
import woowacourse.kanban.board.component.card.domain.ProfileName
import woowacourse.kanban.board.component.card.domain.Title
import woowacourse.kanban.board.component.card.preview.CONTENT_EX
import woowacourse.kanban.board.component.card.preview.NAME_EX
import woowacourse.kanban.board.component.card.preview.TAG_GROUP_EX
import woowacourse.kanban.board.component.card.ui.Profile
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@OptIn(ExperimentalTestApi::class)
class ProfileTest {

    @Test
    fun `닉네임이 있으면 프로필이 노출된다`() = runComposeUiTest {
        //give
        val kanban = Kanban(
            title = Title.DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = TAG_GROUP_EX,
            profileName = NAME_EX,
        )

        setContent {
            KanbanCard(
                kanban = kanban,
            )
        }

        //when
        val profile = onNodeWithContentDescription("프로필 이미지")

        //than
        profile.assertExists()
    }

    @Test
    fun `닉네임이 공백이면 카드를 생성할 수 없다`() {
        //give
        val blankName = "   "
        val kanban = Kanban(
            title = Title.DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = TAG_GROUP_EX,
            profileName = blankName,
        )
        //when
        val nameBlank = assertFailsWith<IllegalArgumentException> {
            runComposeUiTest {
                setContent {
                    KanbanCard(
                        kanban = kanban,
                    )
                }
            }
        }

        //than
        assertEquals(
            ProfileName.PROFILE_WANNING_MESSAGE,
            nameBlank.message,
        )
    }
}
