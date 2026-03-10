package woowacourse.kanban.board.model

class Account(val accountName: String) {
    init {
        require(
            accountName.isNotBlank(),
        ) { ACCOUNT_ERROR }
    }
}
