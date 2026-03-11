package woowacourse.kanban.board.component.card.domain

data class Tag(
    val text: String,
) {
    init {
        require(text.isNotBlank()) { TAGS_WANNING_MESSAGE }
    }

    companion object {
        const val MAX_LENGTH = 5
        const val TAGS_WANNING_MESSAGE = "올바른 태그를 입력해주세요. 공백은 들어갈 수 없습니다."
    }
}
