package woowacourse.kanban.board.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.profile_image
import org.jetbrains.compose.resources.painterResource
import woowacourse.kanban.board.model.TaskCardDto
import woowacourse.kanban.board.model.TaskCardDtoProvider

@Preview()
@Composable
fun TaskCard(@PreviewParameter(TaskCardDtoProvider::class) taskCardDto: TaskCardDto) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier.width(286.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 제목
            TaskTitle(taskCardDto.title)
            Text(
                text = taskCardDto.contents,
                modifier = Modifier
                    .size(width = 252.dp, height = 40.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                taskCardDto.tags.forEach { tag ->
                    SuggestionChip(
                        label = { Text(tag) },
                        onClick = { },
                    )
                }
            }
            Row(
                modifier = Modifier
                    .size(width = 252.dp, height = 45.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(Res.drawable.profile_image),
                    contentDescription = "프로필 이미지",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterVertically),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = taskCardDto.author,
                    modifier = Modifier
                        .height(20.dp)
                        .align(Alignment.CenterVertically),
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskTitle(@PreviewParameter(TitleProvider::class) title: String) {
    Text(
        text = title,
        modifier = Modifier
            .size(width = 252.dp, height = 26.dp),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

class TitleProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "제목",
        "너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무 긴 제목"
    )
}
