package woowacourse.kanban.board.component

class KanbanCardForm(val title: String, val crewName: String) {
    init {
        require(title.isNotBlank()) { "칸반 카드의 제목은 공백이거나 비어있을수 없습니다." }
        require(crewName.isNotBlank()) { "칸반 카드의 담당자는 공백이거나 비어있을수 없습니다." }
    }
}
