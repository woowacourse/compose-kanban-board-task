package woowacourse.kanban.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertFailsWith

@OptIn(ExperimentalTestApi::class)
class KanbanBoardDataTest {
    @Test
    fun `제목 미입력 오류 테스트`() = runComposeUiTest {
        assertFailsWith<IllegalArgumentException> {
            CardData.createCard(
                title = "",
                content = "본문",
                tags = listOf("태그"),
                writer = "작성자"
            )
        }
    }

    @Test
    fun `작성자 정보 미입력 오류 테스트`() = runComposeUiTest {
        assertFailsWith<IllegalArgumentException> {
            CardData.createCard(
                title = "제목",
                content = "본문",
                tags = listOf("태그"),
                writer = ""
            )
        }
    }

    @Test
    fun `태그 개수(5개 이상) 검증 테스트`() = runComposeUiTest {
        assertFailsWith<IllegalArgumentException> {
            CardData.createCard(
                title = "제목",
                content = "본문",
                tags = listOf("태그1", "태그2", "태그3", "태그4", "태그5", "태그6"),
                writer = "작성자"
            )
        }
    }

    @Test
    fun `태그 글자수(5글자 이상) 검증 테스트`() = runComposeUiTest {
        assertFailsWith<IllegalArgumentException> {
            CardData.createCard(
                title = "제목",
                content = "본문",
                tags = listOf("6글자 이상인 태그가 존재하면 오류 발생"),
                writer = "작성자"
            )
        }
    }
}