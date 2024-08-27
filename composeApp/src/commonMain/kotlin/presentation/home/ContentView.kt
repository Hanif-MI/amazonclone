package presentation.home


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentView() {
    val list = listOf(
        "https://drive.usercontent.google.com/download?id=1n2q3aXtMkYuHsc7uliFGnz0yUE5hvu70&export=view&authuser=1",
        "https://drive.usercontent.google.com/download?id=1n2q3aXtMkYuHsc7uliFGnz0yUE5hvu70&export=view&authuser=1",
        "https://drive.usercontent.google.com/download?id=1n2q3aXtMkYuHsc7uliFGnz0yUE5hvu70&export=view&authuser=1",
        "https://drive.usercontent.google.com/download?id=1n2q3aXtMkYuHsc7uliFGnz0yUE5hvu70&export=view&authuser=1",
        "https://drive.usercontent.google.com/download?id=1n2q3aXtMkYuHsc7uliFGnz0yUE5hvu70&export=view&authuser=1",
        "https://drive.usercontent.google.com/download?id=1n2q3aXtMkYuHsc7uliFGnz0yUE5hvu70&export=view&authuser=1",
    )

    val pagerState = rememberPagerState(
        initialPage = 1,
        pageCount = { list.size }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalPager(
            modifier = Modifier.height(250.dp),
            contentPadding = PaddingValues(horizontal = 40.dp),
            state = pagerState
        ) { index ->
            // Correctly calculate the offset for the current page
            val pageOffset = if (index == pagerState.currentPage) {
                pagerState.currentPageOffsetFraction
            } else {
                pagerState.currentPageOffsetFraction + (pagerState.currentPage - index)
            }

            // Scale from 0.85f to 1f based on the current page offset
            val scale = 1f - 0.10f * pageOffset.coerceIn(-1f, 1f).absoluteValue

            list.getOrNull(index % list.size)?.let { item ->
                BannerItem(
                    image = item,
                    modifier = Modifier
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                        }
                )
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        var initPage = 1
        while (true) {
            if (initPage > list.size) initPage = 0
            pagerState.animateScrollToPage(initPage++)
            delay(5000)
        }
    }
}


@Composable
fun BannerItem(image: String, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberImagePainter(image)
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize(),
        )
    }
}
