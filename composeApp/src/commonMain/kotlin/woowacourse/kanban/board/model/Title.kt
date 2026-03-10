package woowacourse.kanban.board.model

class Title(val headerText: String) {
    init {
        require(
            headerText.isNotBlank(),
        ) { TITLE_ERROR }
    }
}
