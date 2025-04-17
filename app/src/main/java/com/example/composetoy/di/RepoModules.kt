package com.example.composetoy.di

import com.example.composetoy.data.ContentListRepositoryImpl
import com.example.composetoy.domain.ContentListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModules {

    @Binds
    abstract fun provideContentListRepository(repository: ContentListRepositoryImpl): ContentListRepository
}