package com.example.composetoy.domain.model

import androidx.compose.runtime.Stable

enum class ContentType {
    BANNER, GRID, SCROLL, STYLE
}

@Stable
data class Content(
    val type: ContentType,
    val banners: List<Banner>,
    val goods: List<Goods>,
    val styles: List<Style>
)


