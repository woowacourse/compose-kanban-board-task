package woowacourse.kanban.board.domain

data class Tag(val name: String) {
    companion object {
        const val MAX_LENGTH = 5
        fun from(name: String): Tag = Tag(name.take(MAX_LENGTH))
    }
}
