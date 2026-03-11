package woowacourse.kanban.board.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.card.ui.ContentText
import woowacourse.kanban.board.component.card.ui.Profile
import woowacourse.kanban.board.component.card.ui.TagChipGroup
import woowacourse.kanban.board.component.card.ui.TitleText
import woowacourse.kanban.board.component.card.domain.Kanban
import woowacourse.kanban.board.theme.Color.blueGray100
import woowacourse.kanban.board.theme.Color.blueGray200

@Composable
fun KanbanCard(
    name: String,
    title: String,
    content: String? = null,
    tags: List<String> = emptyList()
) {
    val task = Kanban(
        title = title,
        content = content,
        tags = tags,
        profileName = name
    )

    Column(
        modifier = Modifier
            .width(286.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, blueGray100, shape = RoundedCornerShape(10.dp))
            .padding(17.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TitleText(task.title.text)
        ContentText(task.content?.text)
        TagChipGroup(task.tags.map { it.text })
        HorizontalDivider(color = blueGray200)
        Profile(task.name.text)
    }
}
