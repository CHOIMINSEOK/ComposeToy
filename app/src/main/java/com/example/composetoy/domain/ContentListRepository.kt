package com.example.composetoy.domain

import com.example.composetoy.domain.model.Section

interface ContentListRepository {
    suspend fun getList(): List<Section>
}