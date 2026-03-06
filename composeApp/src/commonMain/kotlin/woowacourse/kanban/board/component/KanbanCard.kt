package woowacourse.kanban.board.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.card.ContentText
import woowacourse.kanban.board.component.card.TitleText
import woowacourse.kanban.board.component.card.Profile
import woowacourse.kanban.board.component.card.TagChipGroup
import woowacourse.kanban.board.theme.Color.blueGray100
import woowacourse.kanban.board.theme.Color.blueGray200

@Composable
fun KanbanCard(
    name: String,
    title: String? = null,
    content: String? = null,
    tags: List<String> = emptyList()
) {
    Column(
        modifier = Modifier
            .width(286.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, blueGray100, shape = RoundedCornerShape(10.dp))
            .padding(17.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TitleText(title)
        ContentText(content)
        TagChipGroup(tags)
        HorizontalDivider(color = blueGray200)
        Profile(name)
    }
}

@Preview(showBackground = true)
@Composable
fun KanbanCardPreview() {
    val tags = listOf("컴포넌트", "성능")
    Box(
        modifier = Modifier
            .padding(10.dp),
    ) {
        KanbanCard(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tags = tags,
            name = "다이노"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KanbanCardEmptyContentPreview() {
    val tags = listOf("컴포넌트", "성능")
    Box(
        modifier = Modifier
            .padding(10.dp),
    ) {
        KanbanCard(
            title = "LazyColumn 컴포넌트 구현",
            tags = tags,
            name = "다이노"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KanbanCardEmptyTagPreview() {
    Box(
        modifier = Modifier
            .padding(10.dp),
    ) {
        KanbanCard(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            name = "다이노"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KanbanCardEmptyInputPreview() {
    Box(
        modifier = Modifier
            .padding(10.dp),
    ) {
        KanbanCard(
            title = "LazyColumn 컴포넌트 구현",
            name = "다이노"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KanbanCardMaxPreview() {
    val tags = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임", "나는6번")
    Box(
        modifier = Modifier
            .padding(10.dp),
    ) {
        KanbanCard(
            title = "너무너무 긴 제목은 한 줄까지만 노출 노출 노출 노출 노출",
            content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노...너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노...",
            name = "너무너무너무 긴 담당자도 한 줄너무너무너무 긴 담당자도 한 줄...너무너무너무 긴 담당자도 한 줄...너무너무너무 긴 담당자도 한 줄...",
            tags = tags
        )
    }
}
