package com.example.green_mlm_project.di

import com.example.green_mlm_project.mngega_feature.data.data_soruce.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApiService():ApiService{
        return ApiService()
    }
}