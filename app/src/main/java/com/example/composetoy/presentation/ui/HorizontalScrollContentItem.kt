package com.example.composetoy.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composetoy.domain.model.Goods

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
            GoodsItem(modifier = Modifier.width(120.dp), goods = it)
        }
    }
}
