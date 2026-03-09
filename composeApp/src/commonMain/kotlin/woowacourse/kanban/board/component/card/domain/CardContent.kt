package woowacourse.kanban.board.component.card.domain

data class CardContent(
    val text: String,
) {
    init {
        require(text.isNotBlank()) { "설명을 입력해주세요." }
    }
}
