package woowacourse.kanban.board.domain

import woowacourse.kanban.board.component.card.domain.Kanban
import woowacourse.kanban.board.component.card.domain.Kanban.Companion.MAX_TAG_COUNT
import woowacourse.kanban.board.component.card.domain.Tag
import woowacourse.kanban.board.component.card.domain.Title
import woowacourse.kanban.board.component.card.preview.CONTENT_EX
import woowacourse.kanban.board.component.card.preview.NAME_EX
import woowacourse.kanban.board.component.card.preview.TAG_EX
import woowacourse.kanban.board.component.card.preview.TAG_GROUP_MAX_EX
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TagTest {

    @Test
    fun `태그가 공백이라면 태그를 생성할 수 없다`() {
        //give
        val blankTag = "   "

        //when
        val tagBlank = assertFailsWith<IllegalArgumentException> { Tag(blankTag) }

        //than
        assertEquals(Tag.TAGS_WANNING_MESSAGE, tagBlank.message)
    }

    @Test
    fun `태그가 정상 입력이면 태그가 정상 생성된다`() {
        //give
        val tag = Tag(TAG_EX)

        //when
        val tagInput = tag.text

        //than
        assertEquals(TAG_EX, tagInput)
    }

    @Test
    fun `태그는 5개까지만 유지되고 각 태그는 5글자로 제한된다`() {
        //give
        val task = Kanban(
            title = Title.DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = TAG_GROUP_MAX_EX,
            profileName = NAME_EX
        )

        //when
        val size = task.tags.size
        val firstTag = task.tags.first().text

        //than
        assertEquals(MAX_TAG_COUNT, size)
        assertEquals(TAG_GROUP_MAX_EX[0], firstTag)
    }
}
