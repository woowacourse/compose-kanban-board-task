package woowacourse.kanban.board.model

class Tags(tagList: List<String>) {
    val displayTags: List<String> = tagList
        .take(Config.MAX_TAG_COUNT)
        .map {
            if (it.length > Config.MAX_TAG_CONTENT_SIZE) it.substring(0, Config.MAX_TAG_CONTENT_SIZE) else it
        }
}
