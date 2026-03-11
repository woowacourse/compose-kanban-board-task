package woowacourse.kanban.board.component.card.domain

data class Kanban(
    val title: Title,
    val content: Content?,
    val tags: List<Tag>,
    val name: ProfileName
) {
    constructor(
        title: String,
        content: String?,
        tags: List<String>,
        profileName: String
    ) : this(
        title = Title(title.trim().ifBlank { Title.DEFAULT_TITLE }),
        content = content?.trim().orEmpty().takeIf { it.isNotBlank() }?.let(::Content),
        tags = tags
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .take(MAX_TAG_COUNT)
            .map { Tag(it.take(Tag.MAX_LENGTH)) },
        name = ProfileName(profileName.trim())
    )

    companion object{
        const val MAX_TAG_COUNT = 5
    }

}
