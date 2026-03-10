package woowacourse.kanban.board.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import woowacourse.kanban.board.domain.Tag

class TaskTest {

    @Test
    fun `제목이 비어 있으면 예외가 발생한다`() {
        assertFailsWith<IllegalArgumentException> {
            Task(
                title = "",
                contents = null,
                contactName = "디이노",
            )
        }
    }

    @Test
    fun `담당자가 비어 있으면 예외가 발생한다`() {
        assertFailsWith<IllegalArgumentException> {
            Task(
                title = "태스크제목입니다",
                contents = null,
                contactName = "",
            )
        }
    }

    @Test
    fun `유효한 제목과 담당자로 Task를 생성할 수 있다`() {
        val task = Task(
            title = "태스크제목입니다",
            contents = "내용입니다",
            contactName = "디이노",
        )
        assertEquals("태스크제목입니다", task.title)
        assertEquals("내용입니다", task.contents)
        assertEquals("디이노", task.contactName)
    }

    @Test
    fun `내용이 null일 수 있다`() {
        val task = Task(
            title = "태스크제목입니다",
            contents = null,
            contactName = "디이노",
        )
        assertNull(task.contents)
    }

    @Test
    fun `태그가 없으면 빈 리스트로 생성된다`() {
        val task = Task(
            title = "태스크제목입니다",
            contents = null,
            contactName = "디이노",
        )
        assertEquals(emptyList(), task.tags)
    }

    @Test
    fun `태그 개수가 5개를 초과하면 5개까지만 저장된다`() {
        val task = Task(
            title = "태스크제목입니다",
            contents = null,
            tagNames = listOf("태그1", "태그2", "태그3", "태그4", "태그5", "태그6"),
            contactName = "디이노",
        )
        assertEquals(Task.MAX_TAG_COUNT, task.tags.size)
    }

    @Test
    fun `태그 이름이 5자를 초과하면 5자까지 잘린다`() {
        val task = Task(
            title = "태스크제목입니다",
            contents = null,
            tagNames = listOf("태그는5자까지"),
            contactName = "홍길동",
        )
        assertEquals(Tag.MAX_LENGTH, task.tags[0].name.length)
        assertEquals("태그는5자", task.tags[0].name)
    }
}

