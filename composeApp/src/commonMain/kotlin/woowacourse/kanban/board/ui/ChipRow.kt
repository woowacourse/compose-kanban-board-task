package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.constant.ConstantDescs.DEFAULT_NAME
import woowacourse.kanban.board.constants.TAG_BG
import woowacourse.kanban.board.model.Tags

@Composable
fun ChipRow(displayTags: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.testTag("tagRow"),
    ) {
        displayTags.forEach {
            CustomChip(
                text = it,
            )
        }
    }
}

@Composable
fun CustomChip(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(
                color = Color(TAG_BG),
                shape = RoundedCornerShape(16.dp),
            )
            .padding(
                vertical = 5.dp,
                horizontal = 8.dp,
            )
            .testTag("tag"),
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
        )
    }
}

class TagsPreviewParameterProvider : PreviewParameterProvider<Tags> {
    override val values = sequenceOf(
        Tags(
            tagList = listOf(
                "너무너무",
                "긴 태그",
                "최대로",
                "5자까지진짜로",
                "5개제한임",
                "6개",
            ),
        ),
    )
}

@Composable
@Preview
private fun TagsPreview(@PreviewParameter(TagsPreviewParameterProvider::class) data: Tags) {
    ChipRow(displayTags = data.displayTags)
}
