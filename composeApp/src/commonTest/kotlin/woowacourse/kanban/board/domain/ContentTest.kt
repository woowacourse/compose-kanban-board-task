package woowacourse.kanban.board.domain

import woowacourse.kanban.board.component.card.domain.Kanban
import woowacourse.kanban.board.component.card.domain.Title
import woowacourse.kanban.board.component.card.preview.CONTENT_EX
import woowacourse.kanban.board.component.card.preview.NAME_EX
import woowacourse.kanban.board.component.card.preview.TAG_GROUP_EX
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ContentTest {

    @Test
    fun `설명이 공백이면 null로 정규화된다`() {
        //give
        val contentBlank = Kanban(
            title = Title.DEFAULT_TITLE,
            content = "   ",
            tags = TAG_GROUP_EX,
            profileName = NAME_EX
        )

        //when

        //than
        assertNull(contentBlank.content)
    }

    @Test
    fun `설명이 정상 입력되면 해당 내용으로 생성된다`() {
        //give
        val contentInput = Kanban(
            title = Title.DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = TAG_GROUP_EX,
            profileName = NAME_EX
        )

        //when

        //than
        assertEquals(CONTENT_EX, contentInput.content?.text)
    }
}
