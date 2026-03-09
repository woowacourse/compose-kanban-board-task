package woowacourse.kanban.board.component.card.domain

data class Content(
    val text: String,
) {
    init {
        require(text.isNotBlank()) { "설명을 입력해주세요." }
    }
}
