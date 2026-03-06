package woowacourse.kanban.board.component.card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
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
fun ContentTextPreview() {
    ContentText(content = "LazyColumn 컴포넌트 구현")
}

@Composable
@Preview(showBackground = true)
fun ContentTextMaxPreview() {
    ContentText(content = "LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현")
}
