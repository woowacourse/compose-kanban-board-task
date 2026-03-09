package woowacourse.kanban.board.component.preview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.KanbanCard

private data class KanbanCardPreviewData(
    val title: String? = null,
    val content: String? = null,
    val tags: List<String> = emptyList(),
    val name: String = NAME_EX,
)

private class TagPreviewParameterProvider : PreviewParameterProvider<KanbanCardPreviewData> {
    override val values = sequenceOf(
        KanbanCardPreviewData(
            content = CONTENT_EX,
            tags = TAG_GROUP_EX
        ),
        KanbanCardPreviewData(
            tags = TAG_GROUP_EX
        ),
        KanbanCardPreviewData(
            content = CONTENT_EX,
            tags = TAG_GROUP_EX
        ),
        KanbanCardPreviewData(),
        KanbanCardPreviewData(
            title = TITLE_MAX_EX,
            content = CONTENT_MAX_EX,
            tags = TAG_GROUP_MAX_EX,
            name = NAME_MAX_EX
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun KanbanCardPreview(
    @PreviewParameter(TagPreviewParameterProvider::class) kanbanCardPreview: KanbanCardPreviewData,
) {
    Box(
        modifier = Modifier.padding(10.dp),
    ) {
        KanbanCard(
            title = kanbanCardPreview.title,
            content = kanbanCardPreview.content,
            tags = kanbanCardPreview.tags,
            name = kanbanCardPreview.name,
        )
    }
}
