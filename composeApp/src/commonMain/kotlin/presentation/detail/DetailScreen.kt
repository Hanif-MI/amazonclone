@file:OptIn(ExperimentalResourceApi::class, ExperimentalResourceApi::class)

package presentation.detail

import presentation.common_components.RatingBar
import amazonclone.composeapp.generated.resources.Res
import amazonclone.composeapp.generated.resources.delivery
import amazonclone.composeapp.generated.resources.export
import amazonclone.composeapp.generated.resources.refresh
import amazonclone.composeapp.generated.resources.vector
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.common_components.TextWithLineThrough
import utils.calculateDiscountedPrice
import kotlin.math.roundToInt

@OptIn(ExperimentalResourceApi::class)
@Composable
fun DetailScreen(modifier: Modifier = Modifier, result: Product?, onClick: () -> Unit) {
    if (result != null) {
        var selectedIndex by remember { mutableIntStateOf(0) }

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize().verticalScroll(
                rememberScrollState()
            )
        ) {
            Column {
                ImageAutoSlider(list = result.images)
                Column(Modifier.padding(horizontal = 10.dp)) {
                    Text(
                        text = result.description,
                        maxLines = 2,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = Color.Black
                        ),
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
                    ) {
                        Row {

                            Text(
                                text = "Store: ",
                                maxLines = 2,
                                style = TextStyle(
                                    fontWeight = FontWeight.Thin,
                                    fontSize = 14.sp,
                                    color = Color.Black
                                ),
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                            Text(
                                text = "Hanfi",
                                maxLines = 2,
                                style = TextStyle(
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Color.Black
                                ),
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RatingBar(size = 14, isFromDetail = true)
                            Text(
                                text = "Reviews",
                                maxLines = 2,
                                style = TextStyle(
                                    fontWeight = FontWeight.Thin,
                                    fontSize = 14.sp,
                                    color = Color.Black
                                ),
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.delivery),
                            contentDescription = null
                        )
                        Text(
                            text = "FREE delivery",
                            maxLines = 2,
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = Color(0xFF0EB45A)
                            ),
                            modifier = Modifier.padding(4.dp)
                        )
                        Text(
                            text = "August 01 - 03",
                            maxLines = 2,
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                            ),
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
                Box(Modifier.fillMaxWidth().background(Color(0xFFE9E9E9))) {
                    Column {

                        Row(Modifier.padding(10.dp)) {
                            Text(
                                text = "Color: ",
                                maxLines = 2,
                                style = TextStyle(
                                    fontWeight = FontWeight.Thin,
                                    fontSize = 14.sp,
                                    color = Color.Black
                                ),
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                            Text(
                                text = "4 - Light Grey",
                                maxLines = 2,
                                style = TextStyle(
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Color.Black
                                ),
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                        LazyRow(
                            modifier = modifier.fillMaxWidth().padding(bottom = 20.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(
                                horizontal = 10.dp
                            ),
                        ) {
                            val list = mutableListOf<String>()
                            list.addAll(result.images)
                            list.addAll(result.images)
                            itemsIndexed(list) { index, item ->
                                Box(Modifier.size(100.dp)) {
                                    val painter = rememberImagePainter(item)
                                    Image(
                                        painter = painter,
                                        contentDescription = null,
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier.fillMaxSize()
                                            .clip(RoundedCornerShape(6))
                                            .background(Color.Black).clickable {
                                                selectedIndex = index
                                            }.then(
                                                if (selectedIndex == index) Modifier.border(
                                                    width = 2.dp,
                                                    color = Color(0xFFFF9900),
                                                    shape = RoundedCornerShape(6.dp)
                                                ) else Modifier
                                            ),
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Column {
                HorizontalDivider(thickness = 1.dp)
                LazyRow(
                    modifier = modifier.fillMaxWidth().padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(
                        horizontal = 10.dp
                    ),
                ) {
                    itemsIndexed(ChipListData) { index, chipModel ->
                        AssistChip(
                            onClick = { },
                            label = { Text(chipModel.name) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(chipModel.icon),
                                    contentDescription = "Localized description",
                                    Modifier.size(AssistChipDefaults.IconSize)
                                )
                            }
                        )
                        Spacer(Modifier.width(3.dp))
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,

                        ) {
                        Column {
                            TextWithLineThrough("$${result.price}", fontSize = 15)
                            Text(
                                text = "-10%",
                                maxLines = 1,
                                style = TextStyle(
                                    fontWeight = FontWeight.Thin,
                                    fontSize = 14.sp,
                                    color = Color.Red
                                ),
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "$${calculateDiscountedPrice(result.price).roundToInt()}",
                            maxLines = 1,
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 20.sp,
                                color = Color.Black
                            ),
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                    Row(
                    ) {
                        Box(Modifier.border(1.dp, Color(0xFFA7A5A5), RoundedCornerShape(20))) {
                            Text(
                                "Qty: 1", style = TextStyle(
                                    fontWeight = FontWeight.ExtraLight,
                                    fontSize = 16.sp,
                                    color = Color.Black
                                ), modifier = Modifier.padding(10.dp)
                            )
                        }

                        Spacer(Modifier.width(5.dp))

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20))
                                .background(Color(0xFFFF9900))
                        ) {
                            Text(
                                "Add to Cart", style = TextStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 16.sp,
                                    color = Color.White
                                ), modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                }

            }
        }
    } else
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Something went wrong")
        }
}


data class ChipModel(
    val name: String,
    val icon: DrawableResource
)

val ChipListData = listOf(
    ChipModel(name = "View 360º", icon = Res.drawable.refresh),
    ChipModel(name = "View in Your Room", icon = Res.drawable.vector),
    ChipModel(name = "Share", icon = Res.drawable.export),
)