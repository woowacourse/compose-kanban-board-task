package woowacourse.kanban.board.model

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

data class TaskInfo(
    val title: String,
    val contents: String,
    val tags: List<Tag>,
    val author: String,
) {
    init {
        require(tags.size <= 5) { "태그 개수는 5개까지 입력 가능합니다." }
    }

    fun validateContents(): Boolean {
        return contents.isNotBlank()
    }

    fun validateTags(): Boolean {
        return tags.isNotEmpty() && tags.all { it.content.isNotEmpty() }
    }
}

class TaskInfoProvider : PreviewParameterProvider<TaskInfo> {
    override val values: Sequence<TaskInfo> = sequenceOf(
        TaskInfo(
            title = "제목",
            contents = "내용",
            tags = listOf(Tag("태그"), Tag("태그222"), Tag("태그3"), Tag("태그4"), Tag("태그5")),
            author = "별터",
        ),
        TaskInfo(
            title = "제목",
            contents = "",
            tags = listOf(Tag("")),
            author = "별터",
        ),
        TaskInfo(
            title = "제목",
            contents = "",
            tags = listOf(Tag("태그")),
            author = "별터",
        ),
    )
}
