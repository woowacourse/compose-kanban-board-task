package woowacourse.kanban.board.task

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class TagTest {

    @Test
    fun `태그 이름이 화면에 노출된다`() = runComposeUiTest {
        setContent {
            TaskTags(tagNames = listOf("컴포넌트"))
        }
        onNodeWithText("컴포넌트", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `태그 개수만큼 버튼이 생성된다`() = runComposeUiTest {
        setContent {
            TaskTags(tagNames = listOf("컴포넌트", "성능", "긴 태그"))
        }
        val buttonMatcher = SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button)
        onAllNodes(buttonMatcher, useUnmergedTree = true).assertCountEquals(3)
    }

    @Test
    fun `태그가 없으면 아무것도 노출되지 않는다`() = runComposeUiTest {
        setContent {
            TaskTags(tagNames = emptyList())
        }
        val buttonMatcher = SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button)
        onAllNodes(buttonMatcher, useUnmergedTree = true).assertCountEquals(0)
    }
}

