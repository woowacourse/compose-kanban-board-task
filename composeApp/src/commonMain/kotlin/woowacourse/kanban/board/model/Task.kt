package woowacourse.kanban.board.model

data class Task(
    val title: Title,
    val description: Description,
    val tagGroup: TagGroup,
    val assignee: Assignee,
)
