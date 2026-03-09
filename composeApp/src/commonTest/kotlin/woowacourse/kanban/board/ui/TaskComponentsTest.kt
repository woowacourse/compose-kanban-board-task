package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.model.TaskInfo
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TaskComponentsTest {
    @Test
    fun `모든 필드가 있는 카드 - 제목 설명 태그 담당자 모두 노출된다`(): Unit = runComposeUiTest {
        // given
        val taskInfo = TaskInfo(
            title = "컴포넌트",
            contents = "모든 필드가 존재",
            tags = listOf("성능"),
            author = "별터"
        )
        // when
        setContent {
            TaskCard(taskInfo)
        }
        // then
        onNodeWithText("컴포넌트", useUnmergedTree = true).assertExists()
        onNodeWithText("모든 필드가 존재", useUnmergedTree = true).assertExists()
        onNodeWithText("성능", useUnmergedTree = true).assertExists()
        onNodeWithText("별터", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `카드가 두 개일 때 두 개의 카드 모두 노출된다`(): Unit = runComposeUiTest {
        // given
        val taskInfo1 = TaskInfo(
            title = "컴포넌트",
            contents = "내용",
            tags = listOf("성능"),
            author = "별터"
        )
        val taskInfo2 = TaskInfo(
            title = "컴포컴포",
            contents = "내내",
            tags = listOf("성성"),
            author = "별별"
        )

        // when
        setContent {
            TaskCardList(listOf(taskInfo1, taskInfo2))
        }

        // then
        onNodeWithText("컴포넌트", useUnmergedTree = true).assertExists()
        onNodeWithText("내내", useUnmergedTree = true).assertExists()
    }
}