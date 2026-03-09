package woowacourse.kanban.board.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun KanbanCardTags(tags: List<String>) {
    FlowRow(
        modifier = Modifier.testTag("tags"),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        tags
            .take(5)
            .forEach { tag -> TagChip(name = tag) }
    }
}
