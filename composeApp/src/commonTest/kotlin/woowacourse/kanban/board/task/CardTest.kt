package woowacourse.kanban.board.task

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test
import woowacourse.kanban.board.domain.Task

@OptIn(ExperimentalTestApi::class)
class CardTest {

    @Test
    fun `제목 설명 태그 담당자 모두 노출`() = runComposeUiTest {
        val task = TaskFixture.task()
        setContent {
            TaskCard(task = task)
        }
        onNodeWithText("LazyColumn 컴포넌트 구현", useUnmergedTree = true).assertExists()
        onNodeWithText("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.", useUnmergedTree = true).assertExists()
        onNodeWithText("컴포넌트", useUnmergedTree = true).assertExists()
        onNodeWithText("성능", useUnmergedTree = true).assertExists()
        onNodeWithText("다이노", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `제목 태그 담당자만 노출`() = runComposeUiTest {
        val task = TaskFixture.task(
            contents = null,
            tagNames = listOf("컴포넌트")
        )
        setContent {
            TaskCard(task = task)
        }
        onNodeWithText("LazyColumn 컴포넌트 구현", useUnmergedTree = true).assertExists()
        onNodeWithText("컴포넌트", useUnmergedTree = true).assertExists()
        onNodeWithText("다이노", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `제목 설명 담당자만 노출`() = runComposeUiTest {
        val task = TaskFixture.task(
            tagNames = emptyList()
        )
        setContent {
            TaskCard(task = task)
        }
        onNodeWithText("LazyColumn 컴포넌트 구현", useUnmergedTree = true).assertExists()
        onNodeWithText("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.", useUnmergedTree = true).assertExists()
        onNodeWithText("다이노", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `제목 담당자만 노출`() = runComposeUiTest {
        val task = TaskFixture.task(
            contents = null,
            tagNames = emptyList()
        )
        setContent {
            TaskCard(task = task)
        }
        onNodeWithText("LazyColumn 컴포넌트 구현", useUnmergedTree = true).assertExists()
        onNodeWithText("다이노", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `태그 2개 노출`() = runComposeUiTest {
        val task = TaskFixture.task(
            title = "태스크",
            contents = null
        )
        setContent {
            TaskCard(task = task)
        }
        val buttonMatcher = SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button)
        onAllNodes(buttonMatcher, useUnmergedTree = true).assertCountEquals(2)
    }
}

object TaskFixture {

    fun task(
        title: String = "LazyColumn 컴포넌트 구현",
        contents: String? = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
        tagNames: List<String> = listOf("컴포넌트", "성능"),
        contactName: String = "다이노"
    ): Task {
        return Task(title, contents, tagNames, contactName)
    }
}
