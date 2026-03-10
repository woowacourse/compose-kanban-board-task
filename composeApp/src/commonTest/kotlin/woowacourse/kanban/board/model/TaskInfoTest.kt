package woowacourse.kanban.board.model

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Assert.assertFalse
import org.junit.Test

class TaskInfoTest {
    @Test
    fun `태스크 내용이 비어 있으면 false를 반환한다`() {
        // given
        val taskInfo = TaskInfo("제목", "", listOf(Tag("태그")), "별터")
        // when
        val result = taskInfo.validateContents()
        // then
        assertFalse(result)
    }

    @Test
    fun `태스크 태그가 비어 있으면 false를 반환한다`() {
        // given
        val taskInfo = TaskInfo("제목", "내용", listOf(Tag("")), "별터")
        // when
        val result = taskInfo.validateTags()
        // then
        assertFalse(result)
    }

    @Test
    fun `태스크 태그가 5개일 때 에러가 발생하지 않는다`() {
        // given
        val tags = listOf(Tag("1"), Tag("2"), Tag("3"), Tag("4"), Tag("5"))
        // when & then
        assertThatCode {
            TaskInfo("제목", "내용", tags, "별터")
        }.doesNotThrowAnyException()
    }

    @Test
    fun `태스크 태그가 6개 이상이면 에러가 발생한다`() {
        // given
        val tags = listOf(Tag("1"), Tag("2"), Tag("3"), Tag("4"), Tag("5"), Tag("6"))
        // when & then
        assertThatThrownBy {
            TaskInfo("제목", "내용", tags, "별터")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("태그 개수는 5개까지 입력 가능합니다.")
    }
}
