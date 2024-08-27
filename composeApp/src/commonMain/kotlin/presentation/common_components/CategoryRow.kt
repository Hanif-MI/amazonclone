package presentation.common_components


import amazonclone.composeapp.generated.resources.Res
import amazonclone.composeapp.generated.resources.electronics
import amazonclone.composeapp.generated.resources.fashion
import amazonclone.composeapp.generated.resources.health
import amazonclone.composeapp.generated.resources.mobiles
import amazonclone.composeapp.generated.resources.play
import amazonclone.composeapp.generated.resources.prime
import amazonclone.composeapp.generated.resources.watch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.myapplication.ui.theme.LightBlue
import com.app.myapplication.ui.theme.LightGreen
import com.app.myapplication.ui.theme.LightPink
import com.app.myapplication.ui.theme.LightYellow
import com.app.myapplication.ui.theme.LightYellow1
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun CategoryRow() {
    val list = listOf(
        CategoryModel("Fashion", Res.drawable.fashion, LightPink),
        CategoryModel("Mobile", Res.drawable.mobiles, LightYellow),
        CategoryModel("Prime", Res.drawable.prime, LightBlue),
        CategoryModel("Electronics", Res.drawable.electronics, LightGreen),
        CategoryModel("Watch", Res.drawable.watch, LightYellow1),
        CategoryModel("MiniTV", Res.drawable.play, LightPink),
        CategoryModel("Health", Res.drawable.health, LightYellow),
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(
            horizontal = 20.dp
        ),
    ) {

        items(list) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
//                        .border(0.5.dp, iconColor, CircleShape)
                        .background(it.color),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painterResource(it.image), it.name,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(if (it.name == "MiniTV") 20.dp else 40.dp)
                    )
                }
                Spacer(Modifier.height(5.dp))
                Text(it.name, style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Bold))
            }
        }
    }
}

@ExperimentalResourceApi
data class CategoryModel(val name: String, val image: DrawableResource, val color: Color)
