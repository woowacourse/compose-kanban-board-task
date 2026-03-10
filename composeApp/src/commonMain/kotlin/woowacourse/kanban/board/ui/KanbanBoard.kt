package woowacourse.kanban.board.ui

import AccountInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.constants.BORDER_COLOR
import woowacourse.kanban.board.model.Account
import woowacourse.kanban.board.model.KanbanCardData
import woowacourse.kanban.board.model.Tags
import woowacourse.kanban.board.model.Title

@Composable
fun KanbanBoardCard(data: KanbanCardData) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .width(286.dp)
            .clip(
                shape = RoundedCornerShape(16.dp),
            )
            .background(
                color = Color.White,
            )
            .border(
                color = Color(BORDER_COLOR),
                width = 1.dp,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(all = 17.dp),
    ) {
        CardTitle(headerText = data.title.headerText)
        if (data.hasContent) {
            CardContent(content = data.content)
        }

        ChipRow(displayTags = data.tags.displayTags)
        HorizontalDivider()
        AccountInfo(accountName = data.account.accountName)
    }
}

private class KanbanBoardPreviewProvider : PreviewParameterProvider<KanbanCardData> {
    override val values = sequenceOf(
        KanbanCardData(
            title = Title("Lazy Column 컴포넌트 구현"),
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tags = Tags(
                listOf(
                    "컴포넌트",
                    "성능",
                ),
            ),
            account = Account("다이노"),
        ),
        KanbanCardData(
            title = Title("Lazy Column 컴포넌트 구현"),
            content = "",
            tags = Tags(
                listOf(
                    "컴포넌트",
                    "성능",
                ),
            ),
            account = Account("다이노"),
        ),
        KanbanCardData(
            title = Title("Lazy Column 컴포넌트 구현"),
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tags = Tags(listOf()),
            account = Account("다이노"),
        ),
        KanbanCardData(
            title = Title("Lazy Column 컴포넌트 구현"),
            content = "",
            tags = Tags(listOf()),
            account = Account("다이노"),
        ),
        KanbanCardData(
            title = Title("너무너무 긴 제목은 한 줄까지만 노출너무너무 긴 제목은 한 줄까지만 노출"),
            content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노",
            tags = Tags(
                listOf(
                    "너무너무",
                    "긴 태그",
                    "최대로",
                    "5자까지진짜로",
                    "5개제한임",
                    "6개",
                ),
            ),
            account = Account("너무너무너무 긴 담당자도 한 줄너무너무너무 긴 담당자도 한 줄"),
        ),
    )
}

@Composable
@Preview
private fun KanbanCardPreview(@PreviewParameter(KanbanBoardPreviewProvider::class) data: KanbanCardData) {
    KanbanBoardCard(
        data = data,
    )
}

@Composable
fun CardTitle(modifier: Modifier = Modifier, headerText: String) {
    Text(
        text = headerText,
        fontSize = 16.sp,
        letterSpacing = 0.3.sp,
        lineHeight = 24.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun CardContent(modifier: Modifier = Modifier, content: String) {
    Text(
        text = content,
        fontSize = 14.sp,
        letterSpacing = 0.15.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.W400,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.fillMaxWidth()
            .testTag("content"),
    )
}
