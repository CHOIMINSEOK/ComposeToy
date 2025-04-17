package com.example.composetoy.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.composetoy.domain.model.Goods
import com.example.composetoy.utils.formatCurrency


@Composable
fun GoodsItem(modifier: Modifier, goods: Goods) {
    Column(modifier = modifier) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth().height(120.dp),
                model = goods.thumbnailURL,
                contentDescription = "goods thumbnail",
                contentScale = ContentScale.Crop,
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