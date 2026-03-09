package woowacourse.kanban.board.domain

import woowacourse.kanban.board.model.TaskInfo

class TaskValidator {
    fun validateContents(contents: String): Boolean {
        return contents.isNotBlank()
    }

    fun validateTags(tags: List<String>): Boolean {
        return tags.isNotEmpty() && tags.all { it.isNotEmpty() }
    }

    fun filterTags(tags: List<String>): List<String> {
        return tags
            .filter { it.isNotBlank() }
            .take(5)
            .map { it.take(5) }
    }
}
