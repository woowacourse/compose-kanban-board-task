package woowacourse.kanban.board.component

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class TagChipTest {

    @Test
    fun `5글자 이상의 태그의 이름이 들어오면 상위 5글자만 출력`() = runComposeUiTest {
        // given
        val expect = "6글자이상"

        // when
        setContent {
            TagChip("6글자이상 태그")
        }

        // then
        onNodeWithText(expect).assertExists()
    }
}