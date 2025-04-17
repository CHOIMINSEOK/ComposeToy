package com.example.composetoy.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetoy.domain.model.ContentType
import com.example.composetoy.domain.model.Section

@Composable
fun SectionItem(section: Section) {
    Column(modifier = Modifier.background(color = Color.White)) {
        if (section.header != null) {
            HeaderItem(section.header)
        }
        when(section.contents.type) {
            ContentType.BANNER -> BannerItem(section.contents.banners)
            ContentType.GRID -> GridItem(section.contents.goods)
            ContentType.SCROLL -> HorizontalScrollContentItem(section.contents.goods)
            ContentType.STYLE -> Unit
        }

        Spacer(modifier = Modifier.size(20.dp))
    }

}

@Preview
@Composable
fun SectionItemPreview() {

}