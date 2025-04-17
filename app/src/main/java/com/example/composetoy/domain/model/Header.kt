package com.example.composetoy.domain.model


data class Header(
    val title: String,           // Header의 제목
    val iconURL: String? = null, // Header의 아이콘 이미지 URL
    val linkURL: String? = null, // Header의 ‘전체’ 클릭 시 랜딩할 URL
)
