package woowacourse.kanban.board.model

@JvmInline
value class Tag(val content: String) {
    init {
        require(content.length <= 5) { "태그 길이는 5글자까지 입력 가능합니다." }
    }
}
