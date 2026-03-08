package woowacourse.kanban.board

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun App() {

}

// KanbanBoardTaskCard 컴포넌트
@Composable
fun KanbanBoardCard(cardData: CardData) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(CARD_BACKGROUND_COLOR),
                shape = RoundedCornerShape(10.dp)
            )
            .width(286.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color(BOARD_BACKGROUND_COLOR))
            .padding(17.dp)
            .testTag(CARD_BODY_TEST)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(17.dp)) {
            // 제목 컴포넌트 선언부
            CardTitle(cardData.title)

            // 본문 컴포넌트 선언부
            CardContent(cardData.content)

            // 태그 컴포넌트 선언부
            CardTags(cardData.tags.toList())

            // 구분선
            HorizontalDivider(thickness = 2.dp)

            // 작성자 컴포넌트 선언부
            CardWriterProfile(cardData.writer)
        }
    }
}

// title 컴포넌트 생성 함수
@Composable
fun CardTitle(title: String) {
    Box (
        modifier = Modifier
            .testTag(CARD_TITLE_TEST)
    ){
        Text(
            title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp,
            color = Color(TITLE_COLOR),
        )
    }
}

// content 컴포넌트 생성 함수
@Composable
fun CardContent(description: String?) {
    if (description != null) {
        Box (
            modifier = Modifier
                .testTag(CARD_CONTENT_TEST)
        ){
            Text(
                description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                color = Color(DESCRIPTION_COLOR),
            )
        }
    }
}

// tags 컴포넌트 생성 함수
@Composable
fun CardTags (tags: List<String>) {
    if (tags.isNotEmpty() && tags.size <= 5) {
        FlowRow(
            modifier = Modifier.testTag(CARD_TAGS_TEST),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            for (tag in tags) {
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(TAG_BACKGROUND_COLOR),
                            shape = RoundedCornerShape(45.dp)
                        )
                ) {
                    Text(
                        tag,
                        modifier = Modifier
                            .padding(6.dp),
                        fontSize = 10.sp,
                        color = Color(TAG_TEXT_COLOR))
                }
            }
        }
    }
}

// icon & writer 컴포넌트 생성 함수
@Composable
fun CardWriterProfile(writer: String) {
    Row(
        modifier = Modifier.testTag(CARD_WRITER_TEST),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CardWriterIcon()
        CardWriterNickname(writer)
    }
}

@Composable
fun CardWriterIcon() {
    Icon(
        imageVector = Icons.Default.Person,
        contentDescription = null,
        tint = Color.White,
        modifier = Modifier
            .size(25.dp, 25.dp)
            .clip(CircleShape)
            .border(width = 2.dp, color = Color.Gray)
            .background(color = Color.Gray),
    )
}

@Composable
fun CardWriterNickname(writer: String) {
    Text(
        writer,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        fontSize = 14.sp,
        color = Color(WRITER_TEXT_COLOR)
    )
}

@Composable
@Preview(showBackground = false)
private fun CardBoardPreview() {
    val testDataCollection = listOf(
        CardData.createCard(
            title = EXAMPLE_TITLE,
            content = EXAMPLE_CONTENT,
            tags = listOf("컴포넌트", "성능"),
            writer = EXAMPLE_WRITER
        ),
        CardData.createCard(
            title = EXAMPLE_TITLE,
            tags = listOf("컴포넌트", "성능"),
            writer = EXAMPLE_WRITER
        ),
        CardData.createCard(
            title = EXAMPLE_TITLE,
            content = EXAMPLE_CONTENT,
            writer = EXAMPLE_WRITER
        ),
        CardData.createCard(
            title = EXAMPLE_TITLE,
            writer = EXAMPLE_WRITER
        ),
        CardData.createCard(
            title = MAX_TITLE,
            content = MAX_CONTENT,
            tags = listOf("너무너무", "긴 태그", "최대로", "5자 까지", "5개 제한임"),
            writer = MAX_WRITER
        )
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = testDataCollection) { card ->
            KanbanBoardCard(card)
        }
    }
}