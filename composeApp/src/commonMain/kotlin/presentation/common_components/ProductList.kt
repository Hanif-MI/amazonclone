package presentation.common_components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter
import domain.models.Product
import getScreenSize
import utils.calculateDiscountedPrice
import kotlin.math.roundToInt


@Composable
fun ProductList(
    modifier: Modifier = Modifier,
    list: SnapshotStateList<Product>,
    onClick: (Int) -> Unit = {}
) {

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(
            horizontal = 20.dp
        ),
    ) {
        itemsIndexed(list) { index, item ->
            ProductItem(item) {
                onClick(index)
            }
        }
    }
}

@Composable
fun ProductItem(it: Product, onClick: () -> Unit = {}) {
    val screenSize = getScreenSize()
    println("Screen Width: ${screenSize.width}, Screen Height: ${screenSize.height}")

    Column(
        Modifier.width((screenSize.width * 0.4f).dp).clickable {
            onClick()
        },
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(Modifier.width((screenSize.width * 0.4f).dp).aspectRatio(1f)) {
            val painter = rememberImagePainter(it.images.first())
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(6))
                    .background(Color.Black),
            )
        }
        Text(
            text = it.title,
            maxLines = 2,
            style = TextStyle(fontWeight = FontWeight.Light, fontSize = 14.sp, color = Color.Black),
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Column {
            RatingBar()
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextWithLineThrough("$${it.price}")
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "$${calculateDiscountedPrice(it.price).roundToInt()}",
                    maxLines = 1,
                    style = TextStyle(
                        fontWeight = FontWeight.Thin,
                        fontSize = 14.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}
