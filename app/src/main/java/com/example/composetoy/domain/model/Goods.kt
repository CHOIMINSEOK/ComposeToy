package com.example.composetoy.domain.model

data class Goods(
    val linkURL: String,         // 상품을 선택했을 때 랜딩할 URL
    val thumbnailURL: String,    // 상품 이미지 URL
    val brandName: String,       // 상품의 브랜드명
    val price: Int,              // 상품 가격 (숫자로 가정)
    val saleRate: Int,           // 상품 할인율 (숫자로 가정, % 값)
    val hasCoupon: Boolean       // 쿠폰 노출 여부
)