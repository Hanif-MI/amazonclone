package presentation.common_components

import amazonclone.composeapp.generated.resources.Res
import amazonclone.composeapp.generated.resources.star_filled
import amazonclone.composeapp.generated.resources.star_outline
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun RatingBar(
    rating: Float = 4f,
    totalRatings: Int = 12000,
    maxStars: Int = 5,
    size: Int = 10,
    isFromDetail: Boolean = false,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        for (i in 1..maxStars) {
            val icon = if (i <= rating) {
                painterResource(resource = Res.drawable.star_filled) // Replace with filled star resource
            } else {
                painterResource(resource = Res.drawable.star_outline) // Replace with outlined star resource
            }

            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.then(
                    if (isFromDetail) Modifier.size(14.dp) else Modifier
                )
            )
        }
        Spacer(Modifier.width(5.dp))
        Text(
            text = totalRatings.toString(),
            maxLines = 2,
            style = TextStyle(
                fontWeight = FontWeight.Thin,
                fontSize = size.sp,
                color = Color.Black
            ),
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}
