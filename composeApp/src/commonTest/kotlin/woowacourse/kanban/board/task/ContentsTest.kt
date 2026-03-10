package woowacourse.kanban.board.task

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class ContentsTest {

    @Test
    fun `내용이 있으면 화면에 노출된다`() = runComposeUiTest {
        val contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."
        setContent {
            TaskContents(contents = contents)
        }
        onNodeWithText(contents, useUnmergedTree = true).assertExists()
    }

    @Test
    fun `내용이 공백이면 화면에 노출되지 않는다`() = runComposeUiTest {
        val contents = "  "
        setContent {
            TaskContents(contents = contents)
        }
        onNodeWithText(contents, useUnmergedTree = true).assertDoesNotExist()
    }

    @Test
    fun `긴 내용도 화면에 노출된다`() = runComposeUiTest {
        val longContents = "너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다. 너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다."
        setContent {
            TaskContents(contents = longContents)
        }
        onNodeWithText(longContents, useUnmergedTree = true).assertExists()
    }
}

