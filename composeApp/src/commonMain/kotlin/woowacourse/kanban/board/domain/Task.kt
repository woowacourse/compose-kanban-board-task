package woowacourse.kanban.board.domain

class Task(
    val title: String,
    val contents: String?,
    tagNames: List<String> = emptyList(),
    val contactName: String,
) {
    val tags: List<Tag> = tagNames.take(MAX_TAG_COUNT).map { Tag.from(it) }

    init {
        require(title.isNotBlank()) { "제목은 비어 있을 수 없습니다." }
        require(contactName.isNotBlank()) { "담당자는 비어 있을 수 없습니다." }
    }

    companion object {
        const val MAX_TAG_COUNT = 5
    }
}
