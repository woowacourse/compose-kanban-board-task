package woowacourse.kanban.board.domain

import androidx.compose.ui.test.ExperimentalTestApi
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert.assertFalse
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TaskValidatorTest {
    val taskValidator = TaskValidator()

    @Test
    fun `Task 내용이 비어있으면 false를 반환한다`() {
        // given
        val contents = ""
        // when
        val result = taskValidator.validateContents(contents)
        // then
        assertFalse(result)
    }

    @Test
    fun `Tags 내용이 비어있으면 false를 반환한다`() {
        // given
        val tags = listOf("")
        // when
        val result = taskValidator.validateTags(tags)
        // then
        assertFalse(result)
    }

    @Test
    fun `태그 개수가 5개 이상이면 5개까지만 반환한다`() {
        // given
        val tags = listOf("태그1", "태그2", "태그3", "태그4", "태그5", "태그6")
        // when
        val result = taskValidator.filterTags(tags)
        // then
        assertThat(result).isEqualTo(listOf("태그1", "태그2", "태그3", "태그4", "태그5"))
        assertThat(result).hasSize(5)
    }

    @Test
    fun `태그 글자수가 5자 이상이면 5자까지만 반환한다`() {
        // given
        val tags = listOf("태그여섯글자", "태그5글자")
        // when
        val result = taskValidator.filterTags(tags)
        // then
        assertThat(result).isEqualTo(listOf("태그여섯글", "태그5글자"))
    }
}
