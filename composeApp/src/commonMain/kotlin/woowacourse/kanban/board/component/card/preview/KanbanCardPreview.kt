package woowacourse.kanban.board.component.card.preview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.KanbanCard
import woowacourse.kanban.board.component.card.domain.Kanban
import woowacourse.kanban.board.component.card.domain.Title.Companion.DEFAULT_TITLE

private class TagPreviewParameterProvider : PreviewParameterProvider<Kanban> {
    override val values = sequenceOf(
        Kanban(
            title = DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = TAG_GROUP_EX,
            profileName = NAME_EX,
        ),
        Kanban(
            title = DEFAULT_TITLE,
            content = null,
            tags = TAG_GROUP_EX,
            profileName = NAME_EX,
        ),
        Kanban(
            title = DEFAULT_TITLE,
            content = CONTENT_EX,
            tags = emptyList(),
            profileName = NAME_EX,
        ),
        Kanban(
            title = " ",
            content = CONTENT_EX,
            tags = TAG_GROUP_EX,
            profileName = NAME_EX,
        ),
        Kanban(
            title = TITLE_MAX_EX,
            content = CONTENT_MAX_EX,
            tags = TAG_GROUP_MAX_EX,
            profileName = NAME_MAX_EX,
        ),
    )
}


@Preview(showBackground = true)
@Composable
private fun KanbanCardPreview(
    @PreviewParameter(TagPreviewParameterProvider::class) kanban: Kanban,
) {
    Box(
        modifier = Modifier.padding(10.dp),
    ) {
        KanbanCard(
            kanban = kanban
        )
    }
}
