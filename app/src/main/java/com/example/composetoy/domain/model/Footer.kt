package com.example.composetoy.domain.model

data class Footer(
    val title: String,           // Footer의 제목
    val iconURL: String?,         // Footer의 아이콘 이미지 URL
    val type: FooterType
)

enum class FooterType {
    REFRESH, MORE
}