package com.example.composetoy.data

import com.example.composetoy.data.service.ListApi
import com.example.composetoy.domain.ContentListRepository
import com.example.composetoy.domain.model.Section
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContentListRepositoryImpl @Inject constructor(
    private val listApi: ListApi
): ContentListRepository {
    override suspend fun getList(): List<Section> = withContext(Dispatchers.IO) {
        listApi.getList().data
    }
}