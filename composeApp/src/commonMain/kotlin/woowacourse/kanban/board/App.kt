package woowacourse.kanban.board

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.profile_image
import kanbanboard.composeapp.generated.resources.task_planet
import org.jetbrains.compose.resources.painterResource
import woowacourse.kanban.board.model.TaskCardDto
import woowacourse.kanban.board.ui.OpenInputWindow
import woowacourse.kanban.board.ui.TaskCard

@Composable
@Preview(showBackground = true)
fun App() {
    val taskCardDtoGroup = remember { mutableStateListOf<TaskCardDto>() }
    val openInputWindow = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        TaskCardList(taskCardDtoGroup)
        AddButton(modifier = Modifier.align(Alignment.BottomEnd), openInputWindow)
        if (openInputWindow.value) {
            OpenInputWindow(taskCardDtoGroup, openInputWindow)
        }
    }
}

@Composable
fun AddButton(modifier: Modifier, openInputWindow: MutableState<Boolean>) {
    Button(
        onClick = { openInputWindow.value = true },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF5CFFD1),
            contentColor = Color.Black,
        ),
        modifier = modifier.size(height = 150.dp, width = 250.dp),
    ) {
        Row {
            Image(
                painter = painterResource(Res.drawable.task_planet),
                contentDescription = "추가 버튼 - 할일 행성이",
                modifier = Modifier.size(50.dp),
            )
            Text(
                text = "추가",
                fontSize = 50.sp,
            )
        }
    }
}

@Composable
fun TaskCardList(taskCardDtoGroup: List<TaskCardDto>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(taskCardDtoGroup.size) { item ->
            TaskCard(taskCardDto = taskCardDtoGroup[item])
        }
    }
}
