package woowacourse.kanban.board.task

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test


@OptIn(ExperimentalTestApi::class)
class TitleTest {

    @Test
    fun `제목이 화면에 노출된다`() = runComposeUiTest {
        val title = "LazyColumn 컴포넌트 구현"
        setContent {
            TaskTitle(title = title)
        }
        onNodeWithText(title, useUnmergedTree = true).assertExists()
    }
}

