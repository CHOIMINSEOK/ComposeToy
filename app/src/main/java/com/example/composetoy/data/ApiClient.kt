package com.example.composetoy.data

import com.example.composetoy.data.service.ListApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor() {

    private val apiAdapter = Retrofit
        .Builder()
        .baseUrl("https://meta.musinsa.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun provideListApi(): ListApi = apiAdapter.create(ListApi::class.java)
}