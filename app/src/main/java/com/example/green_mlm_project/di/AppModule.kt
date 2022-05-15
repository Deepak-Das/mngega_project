package com.example.green_mlm_project.di

import com.example.green_mlm_project.mngega_feature.Domain.repository.RepositoryImp
import com.example.green_mlm_project.mngega_feature.Domain.use_case.GetLoginStatus
import com.example.green_mlm_project.mngega_feature.Domain.use_case.GetRegisterStatus
import com.example.green_mlm_project.mngega_feature.Domain.use_case.SponsorSatus
import com.example.green_mlm_project.mngega_feature.Domain.use_case.UseCase
import com.example.green_mlm_project.mngega_feature.data.data_soruce.ApiService
import com.example.green_mlm_project.mngega_feature.data.repository.Repository
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

    @Singleton
    @Provides
    fun provideRepository(apiService: ApiService):Repository{
        return RepositoryImp(apiService);
    }

    @Singleton
    @Provides
    fun provideUseCase(repository: Repository):UseCase{
        return UseCase(
            loginAccount = GetLoginStatus(repository),
            sponsorCheck = SponsorSatus(repository),
            registerAccount = GetRegisterStatus(repository)
        )
    }
}