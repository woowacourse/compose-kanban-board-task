package woowacourse.kanban.board.task

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class ContactTest {

    @Test
    fun `담당자 이름이 화면에 노출된다`() = runComposeUiTest {
        val contactName = "다이노"
        setContent {
            TaskContact(contactName = contactName)
        }
        onNodeWithText("다이노", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `프로필 아이콘이 화면에 노출된다`() = runComposeUiTest {
        setContent {
            TaskContact(contactName = "다이노")
        }
        onNodeWithContentDescription("계정프로필", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `긴 담당자 이름도 화면에 노출된다`() = runComposeUiTest {
        val longContactName = "너무너무너무 긴 담당자도 한 줄로 표시됩니다."
        setContent {
            TaskContact(contactName = longContactName)
        }
        onNodeWithText(longContactName, useUnmergedTree = true).assertExists()
    }
}

