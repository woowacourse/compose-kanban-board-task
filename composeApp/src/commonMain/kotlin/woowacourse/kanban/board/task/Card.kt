package woowacourse.kanban.board.task

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.domain.Task

private class TaskCardPreviewProvider : PreviewParameterProvider<Task> {
    override val values: Sequence<Task> = sequenceOf(
        Task(
            title = "LazyColumn 컴포넌트 구현",
            contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tagNames = listOf("컴포넌트", "성능"),
            contactName = "다이노",
        ),
        Task(
            title = "LazyColumn 컴포넌트 구현",
            contents = null,
            tagNames = listOf("컴포넌트", "성능"),
            contactName = "다이노",
        ),
        Task(
            title = "너무너무긴제목은 한줄까지만 노출됩니다.",
            contents = "너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다. 너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다.",
            tagNames = listOf("너무너무", "성능", "긴 태그", "최대로", "5자까지", "5개제한임"),
            contactName = "너무너무너무 긴 담당자도 한 줄로 표시됩니다.",
        ),
    )
}

@Composable
@Preview(showBackground = true)
private fun TaskCardPreview(
    @PreviewParameter(TaskCardPreviewProvider::class) task: Task,
) {
    MaterialTheme {
        TaskCard(task = task)
    }
}

@Composable
fun TaskCard(task: Task) {
    Column(
        modifier = Modifier
            .width(286.dp)
            .border(2.dp, Color.LightGray, RoundedCornerShape(10.dp))
            .padding(start = 22.5.dp, end = 22.5.dp, top = 22.5.dp, bottom = 22.5.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TaskTitle(task.title)
        if (task.contents != null) TaskContents(task.contents)
        if (task.tags.isNotEmpty()) TaskTags(task.tags.map { it.name })
        TaskContact(task.contactName)
    }
}
