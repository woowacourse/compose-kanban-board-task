package woowacourse.kanban.board.task

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp

private const val MAX_LINES = 1

private class TaskTitlePreviewProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "LazyColumn 컴포넌트 구현",
        "너무너무긴제목은 한줄까지만 노출됩니다.",
    )
}

@Composable
@Preview(showBackground = true)
private fun TaskTitlePreview(
    @PreviewParameter(TaskTitlePreviewProvider::class) title: String
) {
    MaterialTheme {
        TaskTitle(title = title)
    }
}
@Composable
fun TaskTitle(title: String, maxLines: Int = MAX_LINES) {
    Text(
        text = title,
        fontWeight = Bold,
        fontSize = 16.sp,
        fontFamily = FontFamily.SansSerif,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
    )
}
