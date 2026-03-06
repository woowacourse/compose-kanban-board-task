package woowacourse.kanban.board.model

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

data class TaskCardDto(
    val title: String,
    val contents: String,
    val tags: List<String>,
    val author: String,
)

 class TaskCardDtoProvider : PreviewParameterProvider<TaskCardDto> {
    override val values: Sequence<TaskCardDto> = sequenceOf(
        TaskCardDto(
            title = "제목",
            contents = "내용",
            tags = listOf("태그"),
            author = "별터"
        )
    )
}
