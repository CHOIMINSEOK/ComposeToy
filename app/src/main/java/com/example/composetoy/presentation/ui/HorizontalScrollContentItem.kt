package com.example.composetoy.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.composetoy.domain.model.Goods
import com.example.composetoy.utils.formatCurrency

@Composable
fun HorizontalScrollContentItem(
    goods: List<Goods>,
) {
    LazyRow(
        modifier = Modifier.wrapContentHeight().fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 8.dp)
        , horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(goods) {
            GoodsItem(it)
        }
    }
}

@Composable
fun GoodsItem(goods: Goods) {
    Column(modifier = Modifier.width(120.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = goods.thumbnailURL,
                contentDescription = "goods thumbnail"
            )
            if (goods.hasCoupon) {
                Text(
                    modifier = Modifier.align(Alignment.BottomStart)
                        .background(color = Color.Blue)
                        .padding(horizontal = 6.dp, vertical = 2.dp),
                    text = "쿠폰",
                    style = TextStyle(color = Color.White)
                )
            }
        }
        Spacer(modifier = Modifier.size(12.dp))
        Text(goods.brandName)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(goods.price.formatCurrency())
            Text("${goods.saleRate}%", style = TextStyle(color = Color.Red))
        }
    }
}