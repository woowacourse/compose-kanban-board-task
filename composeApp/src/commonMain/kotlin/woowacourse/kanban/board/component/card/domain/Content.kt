package woowacourse.kanban.board.component.card.domain

data class Content(
    val text: String,
) {
    init {
        require(text.isNotBlank()) { CONTENT_WANNING_MESSAGE }
    }

    companion object {
        const val CONTENT_WANNING_MESSAGE = "설명을 입력해주세요."
    }
}
