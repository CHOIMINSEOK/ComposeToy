package com.example.composetoy.di

import com.example.composetoy.data.ApiClient
import com.example.composetoy.data.service.ListApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApiModules {
    @Provides
    fun provideListApi(apiClient: ApiClient): ListApi = apiClient.provideListApi()
}