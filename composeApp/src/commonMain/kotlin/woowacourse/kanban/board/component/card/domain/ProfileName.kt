package woowacourse.kanban.board.component.card.domain

data class ProfileName(
    val text: String,
) {
    init {
        require(text.isNotBlank()) { PROFILE_WANNING_MESSAGE }
    }

    companion object {
        const val PROFILE_WANNING_MESSAGE = "올바른 프로필 이름을 입력해주세요. 미기입 혹은 공백은 허용되지 않습니다"
    }
}
