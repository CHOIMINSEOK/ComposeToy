package com.example.composetoy.presentation.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.composetoy.domain.model.Banner
import kotlinx.coroutines.delay


@Composable
fun BannerItem(banners: List<Banner>) {
    Box {

        val pagerState = rememberPagerState(
            pageCount = { banners.size }
        )

        val visiblePage = pagerState.currentPage % banners.size
        val indexText = remember(visiblePage) {
            "${visiblePage + 1}/${banners.size}"
        }

        LaunchedEffect(Unit) {
            while(true) {
                delay(3000)
                pagerState.animateScrollToPage( (pagerState.currentPage + 1) % banners.size)
            }
        }

        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState,
        ) { page ->

            val banner = banners[page % banners.size]
            Box(modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = banner.thumbnailURL,
                    contentDescription = banner.description,
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = banner.title, style = TextStyle(color = Color.White), fontSize = 16.sp)
                    Spacer(modifier = Modifier.size(8.dp))
                    if (banner.keyword.isNotEmpty() and banner.description.isNotEmpty()) {
                        Text(text = "${banner.keyword} | ${banner.description}", style = TextStyle(color = Color.White))
                    }
                }

            }

        }

        if (banners.size > 1) {
            Text(
                text = indexText,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .background(Color.LightGray)
                    .padding(vertical = 8.dp, horizontal = 12.dp),
            )
        }
    }

}