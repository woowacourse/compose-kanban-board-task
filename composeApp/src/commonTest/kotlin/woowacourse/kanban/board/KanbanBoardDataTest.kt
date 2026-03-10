package woowacourse.kanban.board

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import woowacourse.kanban.board.model.Account
import woowacourse.kanban.board.model.KanbanCardData
import woowacourse.kanban.board.model.Tags
import woowacourse.kanban.board.model.Title

class KanbanBoardDataTest {

    @Test
    fun `제목이 비어 있는 경우 칸반 보드 카드 생성 불가능`() {
        assertFailsWith<IllegalArgumentException> {
            Title("")
        }
    }

    @Test
    fun `제목이 공백인 경우 칸반 보드 카드 생성 불가능`() {
        assertFailsWith<IllegalArgumentException> {
            Title(" ")
        }
    }

    @Test
    fun `담당자 이름이 비어 있는 경우 칸반 보드 카드 생성 불가능`() {
        assertFailsWith<IllegalArgumentException> {
            Account("")
        }
    }

    @Test
    fun `담당자 이름이 공백인 경우 칸반 보드 카드 생성 불가능`() {
        assertFailsWith<IllegalArgumentException> {
            Account(" ")
        }
    }

    @Test
    fun `비어 있지 않고 공백도 아닌 데이터로 칸반 보드 카드 생성`() {
        val data = KanbanCardData(
            title = Title("제목"),
            content = "설명",
            tags = Tags(
                listOf(
                    "태그",
                ),
            ),
            account = Account("담당자명"),
        )

        assertEquals("제목", data.title.headerText)
        assertEquals("설명", data.content)
        assertEquals(listOf("태그"), data.tags.displayTags)
        assertEquals("담당자명", data.account.accountName)
        assertEquals(true, data.hasContent)
    }
}
