package woowacourse.kanban.board.model

@JvmInline
value class TagGroup(val tags: List<Tag>) {
    fun isEmpty(): Boolean {
        return tags.isEmpty()
    }
}
