package com.example.composetoy.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.composetoy.domain.model.Header

@Composable
fun HeaderItem(item: Header) {
    Row(
        modifier = Modifier.fillMaxWidth().wrapContentHeight().background(color = Color.White).padding(horizontal = 12.dp, vertical = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(item.title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(4.dp))
            if (item.iconURL != null) {
                AsyncImage(
                    modifier = Modifier.size(20.dp),
                    model = item.iconURL,
                    contentDescription = "section header icon",
                    contentScale = ContentScale.Crop
                )
            }
        }

        if (item.linkURL != null) {
            // 새 창 열기
            Text("전체")
        }
    }
}

@Preview
@Composable
fun HeaderItemPreview() {
    val header = Header(
        title = "디스커버리 익스페디션 인기 스니커즈: 최대 50% 할인",
        iconURL = null,
        linkURL = "https://www.musinsa.com/brands/discoveryexpedition?category3DepthCodes=&category2DepthCodes=&category1DepthCode=018&colorCodes=&startPrice=&endPrice=&exclusiveYn=&includeSoldOut=&saleGoods=&timeSale=&includeKeywords=&sortCode=discount_rate&tags=&page=1&size=90&listViewType=small&campaignCode=&groupSale=&outletGoods=false&boutiqueGoods="
    )

    HeaderItem(header)
}