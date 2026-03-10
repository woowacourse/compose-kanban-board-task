import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.constants.PROFILE_TINT_COLOR

@Composable
fun AccountInfo(accountName: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "프로필기본값",
            modifier = Modifier.size(24.dp),
            tint = Color(PROFILE_TINT_COLOR),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = accountName,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
