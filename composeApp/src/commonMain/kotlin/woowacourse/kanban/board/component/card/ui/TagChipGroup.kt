package woowacourse.kanban.board.component.card.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.card.domain.Tags
import woowacourse.kanban.board.component.card.preview.TAG_GROUP_MAX_EX

@Composable
fun TagChipGroup(
    tags: List<String>,
    modifier: Modifier = Modifier,
    maxCount: Int = Tags.MAX_TAG_COUNT
) {
    FlowRow(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        tags.take(maxCount)
            .forEach { tag ->
                TagChip(tag = tag)
            }
    }
}

@Preview(showBackground = true)
@Composable
private fun TagChipGroupPreview() {
    Box(
        modifier = Modifier
            .width(100.dp),
    ) {
        TagChipGroup(TAG_GROUP_MAX_EX)
    }
}
