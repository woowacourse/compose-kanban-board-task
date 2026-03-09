package woowacourse.kanban.board.component.card.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.component.card.preview.TAG_EX
import woowacourse.kanban.board.component.card.preview.TAG_MAX_EX
import woowacourse.kanban.board.theme.Color.blueGray100

@Composable
fun TagChip(
    tag: String,
    modifier: Modifier = Modifier,
    maxLength: Int = 5
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(blueGray100)
    ) {
        Text(
            text = tag.take(maxLength),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TagChipPreview() {
    TagChip(TAG_EX)
}

@Preview(showBackground = true)
@Composable
private fun TagChipMaxPreview() {
    TagChip(TAG_MAX_EX)
}
