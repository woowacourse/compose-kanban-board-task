package woowacourse.kanban.board.model

class KanbanCardData(val title: Title, val content: String, val tags: Tags, val account: Account) {

    val hasContent: Boolean = content.isNotEmpty()
}
