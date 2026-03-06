package woowacourse.kanban.board.model

data class TaskCard(
    val title: String,
    val contents: String,
    val tags: List<String>,
    val author: String,
)
