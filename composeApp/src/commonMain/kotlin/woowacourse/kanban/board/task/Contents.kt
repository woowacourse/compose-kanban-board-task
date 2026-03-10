package woowacourse.kanban.board.task

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp

private const val MAX_LINES = 2

private class TaskContentsPreviewProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
        "너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다. 너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다.",
    )
}

@Composable
@Preview(showBackground = true)
private fun TaskContentsPreview(
    @PreviewParameter(TaskContentsPreviewProvider::class) contents: String,
) {
    MaterialTheme {
        TaskContents(contents = contents)
    }
}

@Composable
fun TaskContents(contents: String, maxLines: Int = MAX_LINES) {
    if (contents.isNotBlank()) {
        Text(
            text = contents,
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
