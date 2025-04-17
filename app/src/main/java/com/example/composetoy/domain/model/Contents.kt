package com.example.composetoy.domain.model

enum class ContentType {
    BANNER, GRID, SCROLL, STYLE
}

data class Content(
    val type: ContentType,
    val banners: List<Banner>,
    val goods: List<Goods>,
    val styles: List<Style>
)


