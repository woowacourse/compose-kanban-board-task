package woowacourse.kanban.board.view

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.Description
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.TagGroup
import woowacourse.kanban.board.model.Task
import woowacourse.kanban.board.model.Title

@OptIn(ExperimentalTestApi::class)
class TaskCardTest {
    @Test
    fun `제목, 설명, 태그 그룹, 담당자가 모두 입력된 카드라면 화면에 모두 노출한다`() = runComposeUiTest {
        val task = Task(
            title = Title(text = "LazyColumn 컴포넌트 구현"),
            description = Description("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용"),
            tagGroup = TagGroup(tags = listOf(Tag("컴포넌트"), Tag("성능"))),
            assignee = Assignee(name = "다이노"),
        )

        setContent {
            TaskCard(task = task)
        }

        val (title, description, tagGroup, assignee) = task
        onNodeWithText(title.text).assertIsDisplayed()
        onNodeWithText(description.text).assertIsDisplayed()
        onNodeWithText(assignee.name).assertIsDisplayed()
        tagGroup.tags.forEach { tag ->
            onNodeWithText(tag.text).assertIsDisplayed()
        }
    }

    @Test
    fun `설명과 태그 그룹이 각각 빈 값으로 입력된 경우라면 제목, 담당자만 노출한다`() = runComposeUiTest {
        val task = Task(
            title = Title(text = "LazyColumn 컴포넌트 구현"),
            description = Description.empty,
            tagGroup = TagGroup(tags = listOf()),
            assignee = Assignee(name = "다이노"),
        )

        setContent {
            TaskCard(task = task)
        }

        val (title, _, _, assignee) = task
        onNodeWithTag("DescriptionText").assertDoesNotExist()
        onNodeWithTag("TagBadgeGroup").assertDoesNotExist()
        onNodeWithText(title.text).assertIsDisplayed()
        onNodeWithText(assignee.name).assertIsDisplayed()
    }

    @Test
    fun `설명이 빈 값으로 입력된 경우라면 제목, 태그, 담당자만 노출한다`() = runComposeUiTest {
        val task = Task(
            title = Title(text = "LazyColumn 컴포넌트 구현"),
            description = Description.empty,
            tagGroup = TagGroup(tags = listOf(Tag("컴포넌트"), Tag("성능"))),
            assignee = Assignee(name = "다이노"),
        )

        setContent {
            TaskCard(task = task)
        }

        val (title, _, tagGroup, assignee) = task
        onNodeWithTag("DescriptionText").assertDoesNotExist()
        onNodeWithText(title.text).assertIsDisplayed()
        onNodeWithText(assignee.name).assertIsDisplayed()
        tagGroup.tags.forEach { tag ->
            onNodeWithText(tag.text).assertIsDisplayed()
        }
    }

    @Test
    fun `태그 그룹이 빈 값으로 입력된 경우라면 제목, 설명, 담당자만 노출한다`() = runComposeUiTest {
        val task = Task(
            title = Title(text = "LazyColumn 컴포넌트 구현"),
            description = Description("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용"),
            tagGroup = TagGroup(tags = listOf()),
            assignee = Assignee(name = "다이노"),
        )

        setContent {
            TaskCard(task = task)
        }

        val (title, description, _, assignee) = task
        onNodeWithTag("TagBadgeGroup").assertDoesNotExist()
        onNodeWithText(title.text).assertIsDisplayed()
        onNodeWithText(description.text).assertIsDisplayed()
        onNodeWithText(assignee.name).assertIsDisplayed()
    }

    @Test
    fun `태스크 카드의 태그 그룹은 태그를 최대 5개까지만 노출한다`() = runComposeUiTest {
        val tagGroup = TagGroup(
            tags = listOf(
                Tag("tag1"),
                Tag("tag2"),
                Tag("tag3"),
                Tag("tag4"),
                Tag("tag5"),
                Tag("tag6"),
            ),
        )

        setContent {
            TaskCard(
                task = Task(
                    title = Title(text = "LazyColumn 컴포넌트 구현"),
                    description = Description("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용"),
                    tagGroup = tagGroup,
                    assignee = Assignee(name = "다이노"),
                ),
            )
        }

        tagGroup.tags.take(5).forEach { tag ->
            onNodeWithText(tag.text).assertIsDisplayed()
        }
        onNodeWithText(tagGroup.tags[5].text).assertDoesNotExist()
    }
}
