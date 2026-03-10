package woowacourse.kanban.board

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import woowacourse.kanban.board.model.Account
import woowacourse.kanban.board.model.KanbanCardData
import woowacourse.kanban.board.model.Tags
import woowacourse.kanban.board.model.Title
import woowacourse.kanban.board.ui.KanbanBoardCard

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column {
            KanbanBoardCard(
                KanbanCardData(
                    title = Title("너무너무 긴 제목은 한 줄까지만 노출너무너무 긴 제목은 한 줄까지만 노출"),
                    content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노",
                    tags = Tags(
                        listOf(
                            "너무너무",
                            "긴 태그",
                            "최대로",
                            "5자까지진짜로",
                            "5개제한임",
                            "6개",
                        ),
                    ),
                    account = Account("너무너무너무 긴 담당자도 한 줄너무너무너무 긴 담당자도 한 줄"),
                ),
            )
        }
    }
}
