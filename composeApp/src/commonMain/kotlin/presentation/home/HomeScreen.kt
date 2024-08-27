package presentation.home

import amazonclone.composeapp.generated.resources.Res
import amazonclone.composeapp.generated.resources.microphone
import amazonclone.composeapp.generated.resources.scan
import amazonclone.composeapp.generated.resources.search
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.myapplication.ui.theme.iconColor
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.common_components.CategoryRow
import presentation.common_components.CustomTextField
import presentation.common_components.ProductList


@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel, onClick: (Int) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 20.dp)
                .padding(horizontal = 20.dp)
        ) {
            CustomTextField(
                leadingIcon = {
                    Icon(
                        painterResource(resource = Res.drawable.search),
                        "",
                        modifier = Modifier.padding(horizontal = 10.dp),
                        tint = iconColor
                    )
                },
                trailingIcon = {
                    Row {
                        Icon(
                            painterResource(resource = Res.drawable.scan),
                            "",
                            modifier = Modifier.padding(horizontal = 10.dp), tint = iconColor
                        )

                        Icon(
                            painterResource(resource = Res.drawable.microphone),
                            "",
                            modifier = Modifier.padding(horizontal = 10.dp),
                            tint = iconColor
                        )
                    }
                }
            )

            Spacer(Modifier.width(5.dp))
            Icon(
                painterResource(resource = Res.drawable.scan),
                "",
                modifier = Modifier.size(30.dp)
            )

        }

        Column(Modifier.verticalScroll(rememberScrollState())) {
            ContentView()

            Spacer(modifier = Modifier.height(20.dp))

            CategoryRow()

            Text(
                "Today's Deals",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold),
                modifier = Modifier.padding(20.dp)
            )

            ProductList(Modifier, viewModel.list) {
                onClick(it)
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
