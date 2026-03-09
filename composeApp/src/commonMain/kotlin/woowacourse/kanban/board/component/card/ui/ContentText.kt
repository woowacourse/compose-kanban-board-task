package woowacourse.kanban.board.component.card.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.component.card.preview.CONTENT_EX
import woowacourse.kanban.board.component.card.preview.CONTENT_MAX_EX
import woowacourse.kanban.board.theme.Color.blueGray500

@Composable
fun ContentText(content: String? = null) {
    content?.let { content ->
        Text(
            text = content,
            color = blueGray500,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun ContentTextPreview() {
    ContentText(CONTENT_EX)
}

@Composable
@Preview(showBackground = true)
private fun ContentTextMaxPreview() {
    ContentText(CONTENT_MAX_EX)
}
