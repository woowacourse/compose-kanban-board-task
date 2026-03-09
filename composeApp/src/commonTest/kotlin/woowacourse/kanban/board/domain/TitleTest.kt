package woowacourse.kanban.board.domain

import woowacourse.kanban.board.component.card.domain.Kanban
import woowacourse.kanban.board.component.card.domain.Title
import woowacourse.kanban.board.component.card.preview.CONTENT_EX
import woowacourse.kanban.board.component.card.preview.NAME_EX
import woowacourse.kanban.board.component.card.preview.TAG_GROUP_EX
import kotlin.test.Test
import kotlin.test.assertEquals

class TitleTest {
    @Test
    fun `제목이 비어있다면 기본 제목으로 생성된다`() {
        //give
        val titleWithNull = Kanban(
            title = null,
            content = CONTENT_EX,
            tags = TAG_GROUP_EX,
            profileName = NAME_EX
        )

        //when

        //than
        assertEquals(Title.DEFAULT_TITLE, titleWithNull.title?.text)
    }

    @Test
    fun `제목이 공백이라면 기본 제목으로 생성된다`() {
        //give
        val titleWithBlank = Kanban(
            title = "  ",
            content = CONTENT_EX,
            tags = TAG_GROUP_EX,
            profileName = NAME_EX
        )

        //when

        //than
        assertEquals(Title.DEFAULT_TITLE, titleWithBlank.title?.text)
    }

    @Test
    fun `제목이 정상 입력되면 입력값으로 생성된다`() {
        //give
        val titleInput = Kanban(
            title = Title.DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = TAG_GROUP_EX,
            profileName = NAME_EX
        )

        //when

        //than
        assertEquals(Title.DEFAULT_TITLE, titleInput.title?.text)
    }
}
