package woowacourse.kanban.board

data class CardData(
    val title: String,
    val content: String?,
    val tags: List<String>,
    val writer: String
)