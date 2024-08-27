@file:OptIn(ExperimentalFoundationApi::class, KoinExperimentalAPI::class)

import amazonclone.composeapp.generated.resources.Res
import amazonclone.composeapp.generated.resources.amazonlogo
import amazonclone.composeapp.generated.resources.back
import amazonclone.composeapp.generated.resources.location
import amazonclone.composeapp.generated.resources.menu
import amazonclone.composeapp.generated.resources.notifications
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.myapplication.ui.theme.MyApplicationTheme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import presentation.detail.DetailScreen
import presentation.home.HomeScreen
import presentation.home.HomeViewModel


@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    KoinContext {
        val viewModel = koinViewModel<HomeViewModel>()
        MyApplicationTheme {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            Scaffold(modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing),
                topBar = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.Bottom,
                        ) {

                            Icon(
                                painterResource(resource = if (navBackStackEntry?.destination?.route == "detail/{id}") Res.drawable.back else Res.drawable.menu),
                                "",
                                modifier = Modifier.then(
                                    if (navBackStackEntry?.destination?.route != "detail/{id}") Modifier else Modifier.clickable {
                                        navController.navigateUp()
                                    }
                                )
                            )
                            Spacer(Modifier.width(20.dp))
                            Image(
                                painterResource(resource = Res.drawable.amazonlogo),
                                "",
                                modifier = Modifier.width(81.dp).height(24.dp)
                                    .align(Alignment.Bottom)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painterResource(resource = Res.drawable.location),
                                "",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(Modifier.width(5.dp))

                            Column(verticalArrangement = Arrangement.Center) {
                                Text(
                                    "Delivery to",
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        lineHeight = 10.sp  // Set the line height to the same as font size
                                    ),
                                )
                                Text(
                                    "Ahmedabad 380024", style = TextStyle(
                                        fontSize = 10.sp,
                                        lineHeight = 10.sp  // Set the line height to the same as font size
                                    )
                                )
                            }
                            Spacer(Modifier.width(5.dp))
                            Icon(
                                painterResource(resource = Res.drawable.notifications),
                                "",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            ) {
                NavHost(navController, startDestination = "list") {
                    composable("list") {
                        HomeScreen(viewModel) { id ->
                            navController.navigate("detail/$id")
                        }
                    }
                    composable("detail/{id}") { it ->
                        it.arguments?.getString("id")?.let {
                            DetailScreen(
                                modifier = Modifier,
                                viewModel.getProductByIndex(index = it.toInt())
                            ) {
                                navController.navigateUp()
                            }
                        }
                    }
                }
            }

        }
    }
}