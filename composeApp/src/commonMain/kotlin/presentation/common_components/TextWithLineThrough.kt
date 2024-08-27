package presentation.common_components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun TextWithLineThrough(text: String, fontSize: Int = 12) {
    Text(
        text = text,
        style = TextStyle(
            textDecoration = TextDecoration.LineThrough,
            fontWeight = FontWeight.Thin,
            fontSize = fontSize.sp,
            color = Color.Gray
        )
    )
}