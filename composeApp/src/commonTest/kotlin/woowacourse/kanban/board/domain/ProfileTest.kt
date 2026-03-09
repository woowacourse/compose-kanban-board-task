package woowacourse.kanban.board.domain

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

class ProfileTest {

    @Test
    fun `프로필 이름이 공백이면 프로필을 생성할 수 없다`() {
        //give

        //when
        val profileBlank = assertFailsWith<IllegalArgumentException> {
            Kanban(
                title = Title.DEFAULT_TITLE,
                content = CONTENT_EX,
                tags = TAG_GROUP_EX,
                profileName = "   "
            )
        }

        //than
        assertEquals(ProfileName.PROFILE_WANNING_MESSAGE, profileBlank.message)
    }

    @Test
    fun `프로필 이름이 정상 입력이면 프로필이 정상 생성된다`() {
        //give
        val profile = ProfileName(NAME_EX)

        //when
        val profileName = profile.text

        //than
        assertEquals(NAME_EX, profileName)
    }
}
