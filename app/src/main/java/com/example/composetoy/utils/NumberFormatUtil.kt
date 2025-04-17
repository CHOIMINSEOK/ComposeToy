package com.example.composetoy.utils

import java.text.DecimalFormat

fun Int.formatCurrency(): String {
    val formatter = DecimalFormat("#,###")
    return formatter.format(this) + "원"
}