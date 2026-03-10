package woowacourse.kanban.board.model

@JvmInline
value class Description(val text: String) {
    fun isEmpty(): Boolean = text.isEmpty()

    companion object {
        val empty: Description = Description("")
    }
}
