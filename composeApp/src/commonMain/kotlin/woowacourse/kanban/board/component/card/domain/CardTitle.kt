package woowacourse.kanban.board.component.card.domain

data class CardTitle(
    val text: String,
) {
    init {
        require(text.isNotBlank()) { "올바른 제목을 입력해주세요. 아니면 기본값이 부여됩니다." }
    }

    companion object {
        const val DEFAULT_TITLE = "LazyColumn 컴포넌트 구현"
    }
}
