package woowacourse.kanban.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.domain.Task
import woowacourse.kanban.board.task.TaskCard

private class AppPreviewProvider : PreviewParameterProvider<List<Task>> {
    override val values: Sequence<List<Task>> = sequenceOf(
        listOf(
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
                title = "LazyColumn 컴포넌트 구현",
                contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tagNames = emptyList(),
                contactName = "다이노",
            ),
            Task(
                title = "LazyColumn 컴포넌트 구현",
                contents = null,
                tagNames = emptyList(),
                contactName = "다이노",
            ),
            Task(
                title = "너무너무긴제목은 한줄까지만 노출됩니다.",
                contents = "너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다. 너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다.",
                tagNames = listOf("너무너무", "성능", "긴 태그", "최대로", "5자까지", "5개제한임"),
                contactName = "너무너무너무 긴 담당자도 한 줄로 표시됩니다.",
            ),
        ),
    )
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun AppPreview(
    @PreviewParameter(AppPreviewProvider::class) tasks: List<Task>,
) {
    KanbanBoard(tasks = tasks)
}

@Composable
fun App() {
    KanbanBoard(tasks = AppPreviewProvider().values.first())
}

@Composable
private fun KanbanBoard(tasks: List<Task>) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 62.5.dp, vertical = 60.dp)
                .safeContentPadding()
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(18.5.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(18.5.dp),
            ) {
                tasks.take(4).forEach { task ->
                    TaskCard(task = task)
                }
            }
            Row {
                TaskCard(task = tasks.last())
            }
        }
    }
}


