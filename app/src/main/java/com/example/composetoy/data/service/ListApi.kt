package com.example.composetoy.data.service

import com.example.composetoy.domain.model.Section
import retrofit2.http.GET

data class ListResponse(
    val data: List<Section>
)

interface ListApi {
    @GET("/interview/list.json")
    suspend fun getList(): ListResponse
}