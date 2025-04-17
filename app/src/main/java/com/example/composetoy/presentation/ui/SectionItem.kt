package com.example.composetoy.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composetoy.domain.model.ContentType
import com.example.composetoy.domain.model.Footer
import com.example.composetoy.domain.model.FooterType
import com.example.composetoy.domain.model.Header
import com.example.composetoy.domain.model.Section

@Composable
fun SectionItem(section: Section) {
    when(section.contents.type) {
        ContentType.BANNER -> InnerSectionItem(
            header = section.header,
            initialItems = section.contents.banners,
            items = section.contents.banners,
            content = { displayItems -> BannerItem(displayItems) },
            footer = section.footer,
        )
        ContentType.GRID -> InnerSectionItem(
            header = section.header,
            initialItems =  section.contents.goods.take(6),
            items = section.contents.goods,
            content = { displayItems -> GridItem(displayItems) },
            footer = section.footer,
        )
        ContentType.SCROLL -> InnerSectionItem(
            header = section.header,
            initialItems = section.contents.goods,
            items = section.contents.goods,
            content = { displayItems -> HorizontalScrollContentItem(displayItems) },
            footer = section.footer,
        )
        ContentType.STYLE -> InnerSectionItem(
            header = section.header,
            initialItems =  section.contents.styles.take(6),
            items = section.contents.styles,
            content = { displayItems -> StyleItem(displayItems) },
            footer = section.footer,
        )
    }
}


@Composable
private fun <T> InnerSectionItem(
    header: Header?,
    initialItems: List<T>,
    items: List<T>,
    content: @Composable (displayItems: List<T>) -> Unit,
    footer: Footer?
) {
    var displayItems by remember {
        mutableStateOf(initialItems)
    }

    Column(modifier = Modifier.background(color = Color.White)) {
        if (header != null) {
            HeaderItem(header)
        }
        content(displayItems)

        // Footer 타입이 Refresh라면 Footer를 항상 보여준다.
        if (footer != null && (footer.type == FooterType.REFRESH || displayItems.size < items.size)) {
            Spacer(modifier = Modifier.size(12.dp))
            FooterItem(footer, { type ->
                when(type) {
                    FooterType.REFRESH -> displayItems = displayItems.shuffled()
                    FooterType.MORE -> displayItems = items.take(displayItems.size + 3)
                }
            })
        }
        Spacer(modifier = Modifier.size(20.dp))
    }
}