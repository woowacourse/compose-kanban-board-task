package woowacourse.kanban.board.model

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

data class TaskInfo(
    val title: String,
    val contents: String,
    val tags: List<String>,
    val author: String
)

 class TaskInfoProvider : PreviewParameterProvider<TaskInfo> {
    override val values: Sequence<TaskInfo> = sequenceOf(
        TaskInfo(
            title = "제목",
            contents = "내용",
            tags = listOf("태그", "태그222", "태그3", "태그4", "태그5"),
            author = "별터"
        ),
        TaskInfo(
            title = "제목",
            contents = "",
            tags = listOf(""),
            author = "별터"
        ),
        TaskInfo(
            title = "제목",
            contents = "",
            tags = listOf("태그"),
            author = "별터"
        ),
    )
}
