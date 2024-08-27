package presentation.detail


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import getScreenSize
import kotlinx.coroutines.delay
import presentation.common_components.PagerIndicator
import kotlin.math.roundToInt


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageAutoSlider(list: List<String>) {
    val screenSize = getScreenSize()
    val pagerState = rememberPagerState(
        initialPage = 1,
        pageCount = { list.size }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth().padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth().height((screenSize.height * 0.4f).roundToInt().dp),
            state = pagerState
        ) { index ->
            list.getOrNull(index % list.size)?.let { item ->
                DetailBannerItem(
                    image = item
                )
            }
        }

        PagerIndicator(
            modifier = Modifier.padding(vertical = 5.dp),
            pagerState = pagerState,
            indicatorSize = 10.dp,
            indicatorCount = list.size,
            activeColor = Color(0xffFFC107),
            inActiveColor = Color(0xffFFECB3),
            indicatorShape = CutCornerShape(4.dp)
        )
    }

    LaunchedEffect(key1 = Unit) {
        var initPage = 0
        while (true) {
            if (initPage > list.size) initPage = 0
            pagerState.animateScrollToPage(initPage++)
            delay(5000)
        }
    }
}


@Composable
fun DetailBannerItem(image: String) {
    val painter = rememberImagePainter(image)
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize(),
    )
}