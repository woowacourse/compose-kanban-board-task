package woowacourse.kanban.board.component.card.domain

data class Tags(
    val text: String,
) {
    init {
        require(text.isNotBlank()) { "올바른 태그를 입력해주세요. 공백은 들어갈 수 없습니다." }
    }

    companion object {
        const val MAX_LENGTH = 5
        const val MAX_TAG_COUNT = 5
    }
}
