package woowacourse.kanban.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Account
import woowacourse.kanban.board.model.KanbanCardData
import woowacourse.kanban.board.model.Tags
import woowacourse.kanban.board.model.Title
import woowacourse.kanban.board.ui.KanbanBoardCard

class KanbanBoardCardTest {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `칸반 보드 카드에 모든 정보가 있는 경우`() = runComposeUiTest {
        setContent {
            KanbanBoardCard(
                data = KanbanCardData(
                    title = Title("제목"),
                    content = "설명",
                    tags = Tags(
                        listOf(
                            "태그",
                        ),
                    ),
                    account = Account("담당자명"),
                ),
            )
        }
        onNodeWithText("제목").assertExists()
        onNodeWithText("설명").assertExists()
        onNodeWithText("태그").assertExists()
        onNodeWithText("담당자명").assertExists()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `칸반 보드 카드에 설명이 없는 경우`() = runComposeUiTest {
        setContent {
            KanbanBoardCard(
                data = KanbanCardData(
                    title = Title("제목"),
                    content = "",
                    tags = Tags(
                        listOf(
                            "태그",
                        ),
                    ),
                    account = Account("담당자명"),
                ),
            )
        }
        onNodeWithTag("content").assertDoesNotExist()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `칸반 보드 카드에 태그가 없는 경우`() = runComposeUiTest {
        setContent {
            KanbanBoardCard(
                data = KanbanCardData(
                    title = Title("제목"),
                    content = "설명",
                    tags = Tags(emptyList()),
                    account = Account("담당자명"),
                ),
            )
        }
        onNodeWithTag("tag").assertDoesNotExist()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `칸반 보드 카드에 태그 5개 초과시 5개까지 노출`() = runComposeUiTest {
        setContent {
            KanbanBoardCard(
                data = KanbanCardData(
                    title = Title("제목"),
                    content = "설명",
                    tags = Tags(
                        listOf(
                            "태그1",
                            "태그2",
                            "태그3",
                            "태그4",
                            "태그5",
                            "태그6",
                        ),
                    ),
                    account = Account("담당자명"),
                ),
            )
        }
        onNodeWithTag("tagRow").onChildren().assertCountEquals(5)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `칸반 보드 카드에 태그 텍스트가 5자 초과시 잘린 텍스트 노출`() = runComposeUiTest {
        setContent {
            KanbanBoardCard(
                data = KanbanCardData(
                    title = Title("제목"),
                    content = "설명",
                    tags = Tags(
                        listOf(
                            "다섯글자가넘어가는태그내용",
                        ),
                    ),
                    account = Account("담당자명"),
                ),
            )
        }
        onNodeWithTag("tagRow")
            .onChildren()
            .onFirst()
            .onChildren()
            .onFirst()
            .assertTextEquals("다섯글자가")
    }
}
